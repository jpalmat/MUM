import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 public class Sprint{
	public Sprint(){
		Features = new ArrayList<Feature>();
	}
	List<Feature> Features;
	Date dueDate;
	int amountOfCompletedWork;
	int amountOfRemainingWork;
}