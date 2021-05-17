package hybrid;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import util.*;

public class HybridApproach extends ApproachBase {

	public HybridApproach(){
		super(HybridApproach.class, HybridMapper.class, HybridReducer.class, HybridPartitioner.class);		
	}

  public static void main(String[] args) throws Exception {


    if (args.length != 2) {
      System.out.printf("Number of arguments is not correct, please pass <input dir> <output dir>\n");
      System.exit(-1);
    }
    

    // this should be a even number if n is odd we will apply n-1 reducers
	Job job = new HybridApproach().createJob(args, 2);  
   
     job.setOutputKeyClass(Pair.class);
     job.setOutputValueClass(IntWritable.class);

    boolean success = job.waitForCompletion(true);
    System.exit(success ? 0 : 1);
  }
}


