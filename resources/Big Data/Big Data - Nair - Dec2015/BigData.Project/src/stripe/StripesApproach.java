package stripe;

import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;

import util.ApproachBase;

public class StripesApproach extends ApproachBase {
	public StripesApproach(){
		super(StripesApproach.class, StripesMapper.class, StripesReducer.class, StripesPartitioner.class);		
	}
	

	public static void main(String[] args) throws Exception {
		 
	    if (args.length != 2) {
	      System.out.printf("Number of arguments is not correct, please pass <input dir> <output dir>\n");
	      System.exit(-1);
	    }
	    
	    // this should be a even number, if n is odd we will apply n-1 reducers.
	    Job job = new StripesApproach().createJob(args, 2);    
	    
	    
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(MapWritable.class);
	
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}


