import java.util.ArrayList;
import java.util.List;

public class Project{
	public Project(){
		Backlog = new ArrayList<Feature>();
		Releases = new ArrayList<Release>();
	}
	List<Feature> Backlog;
	List<Release> Releases;	
}