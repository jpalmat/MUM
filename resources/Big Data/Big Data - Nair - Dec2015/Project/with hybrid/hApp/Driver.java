package hApp;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driver {

  @SuppressWarnings("deprecation")
public static void main(String[] args) throws Exception {

    /*
     * Validate that two arguments were passed from the command line.
     */
    if (args.length != 2) {
      System.out.printf("Usage: StubDriver <input dir> <output dir>\n");
      System.exit(-1);
    }

    /*
     * Instantiate a Job object for your job's configuration. 
     */
    Job job = new Job();
    
    /*
     * Specify the jar file that contains your driver, mapper, and reducer.
     * Hadoop will transfer this jar file to nodes in your cluster running 
     * mapper and reducer tasks.
     */
    job.setJarByClass(Driver.class);
    
    
    /*
     * Specify an easily-decipherable name for the job.
     * This job name will appear in reports and logs.
     */
    job.setJobName("Hybrid Approach for relative frequencies - Driver");

    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    FileInputFormat.addInputPath(job, new Path(args[0]));
   
   
    job.setMapperClass(HybridMapper.class);
    job.setReducerClass(HybridReducer.class);
    job.setPartitionerClass(MyPartitioner.class);
    job.setNumReduceTasks(3);
    
   
     job.setOutputKeyClass(Pair.class);
     job.setOutputValueClass(IntWritable.class);
    
    /*
     * Start the MapReduce job and wait for it to finish.
     * If it finishes successfully, return 0. If not, return 1.
     */
    boolean success = job.waitForCompletion(true);
    System.exit(success ? 0 : 1);
  }
}

