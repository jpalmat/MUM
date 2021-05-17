package pair;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import util.ApproachBase;
import util.Pair;

public class PairsApproach extends ApproachBase{

	public PairsApproach(){
		super(PairsApproach.class, PairsMapper.class, PairsReducer.class, PairsPartitioner.class);		
	}
	
	public static void main(String[] args) throws Exception {
	
	    if (args.length != 2) {
	      System.out.printf("Number of arguments is not correct, please pass <input dir> <output dir>\n");
	      System.exit(-1);
	    }
	
	 // this should be a even number, if n is odd we will apply n-1 reducers.
	    Job job = new PairsApproach().createJob(args, 2);  
	    
	    
	    job.setOutputKeyClass(Pair.class);
	    job.setOutputValueClass(IntWritable.class);
	
	
	    boolean success = job.waitForCompletion(true);
	    System.exit(success ? 0 : 1);
	  }
}
