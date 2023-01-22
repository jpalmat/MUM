package lesson10.labs.prob5;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowingFunction<T, R> extends Function<T, R> {

	@Override
	default R apply(T t) {
		try {
			return applyThrows(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	R applyThrows(T t) throws Exception;
}