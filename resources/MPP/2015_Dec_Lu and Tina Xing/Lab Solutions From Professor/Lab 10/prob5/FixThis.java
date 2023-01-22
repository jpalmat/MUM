package lesson10.labs.prob5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FixThis {

	// This method creates a compiler error -- try to fix it
	// First way
	List<String> processList(List<String> list) {

		return list.stream().map(x -> {
			try {
				return doNothingIfShort(x);
			} catch (InputTooLongException ex) {
				System.out.println("GOT InputTooLongException");
				// return ex.getMessage();
				throw new RuntimeException(ex);
			}
		}).collect(Collectors.toList());

	}

	// second way: make another method
	List<String> processList2(List<String> list) {
		return list.stream().map(x -> uncheckedLongWord(x)).collect(Collectors.toList());
	}

	// Third way: Use static method in another functional interface
	List<String> processList6(List<String> list) {
		return list.stream().map(FunctionWithException.unchecked(word -> doNothingIfShort(word)))
				.collect(Collectors.toList());
	}

	// Fourth way: make another functional interface extends Function
	List<String> processList4(List<String> list) {
		return list.stream().map(new ThrowingFunction<String, String>() {

			@Override
			public String applyThrows(String t) throws Exception {
				return doNoth	ingIfShort(t);
			}
		}).collect(Collectors.toList());
	}

	ThrowingFunction<String, String> testFun = t -> doNothingIfShort(t);

	List<String> processList5(List<String> list) {
		return list.stream().map(testFun).collect(Collectors.toList());
	}

	//Fifth way: not recommended
	List<String> processList3(List<String> list) {
		return list.stream().map(x -> FunctionWithException.unchecked((String word) -> doNothingIfShort(word)).apply(x))
				.collect(Collectors.toList());
	}

	private String uncheckedLongWord(String word) {
		try {
			return doNothingIfShort(word);
		} catch (InputTooLongException e) {
			throw new RuntimeException(e);
		}
	}

	String doNothingIfShort(String input) throws InputTooLongException {
		if (input.length() > 3)
			throw new InputTooLongException();
		else
			return input;
	}

	public static void main(String[] args) {
		FixThis ft = new FixThis();
		List<String> words1 = Arrays.asList("not", "too", "big", "yet");
		List<String> words2 = Arrays.asList("Thisdsdsdsd", "is", "too", "big", "yet");
		System.out.println(ft.processList(words1));
		System.out.println(ft.processList2(words2));
	}

	class InputTooLongException extends Exception {
		private static final long serialVersionUID = 1L;

		public InputTooLongException() {
			super("Must be length 3 or less");
		}

		public InputTooLongException(String s) {
			super(s);
		}

		public InputTooLongException(Throwable t) {
			super(t);
		}
	}
}
