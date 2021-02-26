package lecture.optional_map.usingoptionas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
public class Main {
	private static List<Person> persons;
	
	//check if there is a Person on the list from Fairfield
	public static void main(String[] args) {
		loadData();
		
		System.out.println("Found a person in the list from Fairfield? " 
				+ personFromFairfield(persons));
		
		System.out.println(getPerson(persons));
		

		System.out.println(getPersonMap(persons));
	}
	
	private static boolean personFromFairfield(List<Person> persons) {
		for(Person p: persons) {
			if(Optional.ofNullable(p).map(x -> x.getAddress())
					.map(x->x.getCity())
					.orElse("").equals("Fairfield")) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean getPerson(List<Person> persons) {
		
		return Optional.ofNullable(persons)
				.orElseGet(Collections::emptyList)
				.stream()
				.filter(Objects::nonNull)
				.map(x -> x.getAddress())
				.filter(Objects::nonNull)
				.filter(a -> a.getCity().equals("Fairfield"))
				.collect(Collectors.toList()).isEmpty() ? false : true;
	}
	
private static Map<String, String> getPersonMap(List<Person> persons) {
		
		return Optional.ofNullable(persons)
				.orElseGet(Collections::emptyList)
				.stream()
				.filter(Objects::nonNull)
				.map(x -> x.getAddress())
				.filter(Objects::nonNull)
				.filter(a -> a.getCity().equals("Fairfield"))
				.collect(Collectors.toMap(Address::getCity, Address::getZip));
	}
	
	private static void loadData() {
		persons = new ArrayList<>();
		
		Address address = null;
		Person p = new Person();
		p.setName("Joe");
		p.setAddress(address);
		persons.add(p);
		
		address = new Address();
		address.setStreet("111 Main St");
		address.setCity("Fairfield");
		address.setState("IA");
		address.setZip("52556");
		p = new Person();
		p.setName("Joe");
		p.setAddress(address);
		persons.add(p);
		
		address = new Address();
		address.setStreet("1402 Channing Ave");
		address.setCity("Palo Alto");
		address.setState("CA");
		address.setZip("94301");
		p = new Person();
		p.setName("Tom");
		p.setAddress(address);
		persons.add(p);
	}
}
