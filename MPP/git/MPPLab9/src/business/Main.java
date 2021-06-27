package business;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class Main {
	
	static Supplier<DataAccess> df = new Supplier<DataAccess>() {
		
		@Override
		public DataAccessFacade get() {
			// TODO Auto-generated method stub
			return new DataAccessFacade();
		}
	};

	public static void main(String[] args) {
//		System.out.println(allWhoseZipContains3());
//		System.out.println(allHavingOverdueBook());
//		System.out.println(allHavingMultipleAuthors());
		Function<Integer, String> a1 = x -> x.toString();
		Integer[] a = {2, 3};
		System.out.println(Stream.of(a).map(x -> a1.apply(x))
		.collect(Collectors.toList()));
		
		

	}
	
	
	//Returns a list of all ids of LibraryMembers whose zipcode contains the digit 3
	public static List<String> allWhoseZipContains3() {
		return 			df.get().readMemberMap().values().stream()
						.filter(x -> x.getAddress().getZip().contains("3"))
						.map(x -> x.getMemberId())
						.collect(Collectors.toList()); 
	
		
	}
	//Returns a list of all ids of  LibraryMembers that have an overdue book
	public static List<String> allHavingOverdueBook() {
		Collection<LibraryMember> members = df.get().readMemberMap().values();
		List<LibraryMember> mems = new ArrayList<>();
		mems.addAll(members);
		//implement
		return null;
		
	}
	
	//Returns a list of all isbns of  Books that have multiple authors
	public static List<String> allHavingMultipleAuthors() {
		return df.get().readBooksMap().values().stream().filter(x-> x.getAuthors().size()>1).map(x->x.getIsbn()).collect(Collectors.toList());
		
		}
	
	
	
	

}
