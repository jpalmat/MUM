import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;




public class NoCombiner {
	  public static class YearMapper
      extends Mapper<Object, Text, IntWritable, DoubleWritable>{

		  
		private  String  localLine=null;

   public void map(Object key, Text value, Context context
                   ) throws IOException, InterruptedException {
	   
	     localLine=value.toString();
	   int mapKey=Integer.parseInt(localLine.substring(15, 23));
	   
	   double mapValue=Double.parseDouble(localLine.substring(87,92))/10;
	   
	   System.out.println(mapValue);
	   context.write(new IntWritable(mapKey), new DoubleWritable(mapValue));
	
	   
   }
  
   
   protected void cleanup(Context context)
		   throws IOException, InterruptedException {
		 System.out.println("Done");
		  }
   
 }
	  
	  
	  public static class YearReducer
      extends Reducer<IntWritable,DoubleWritable,IntWritable,DoubleWritable>
	  {
		  private DoubleWritable result = new DoubleWritable();

		  
		  public void reduce(IntWritable key, Iterable<DoubleWritable> values,
                    Context context
                    ) throws IOException, InterruptedException {
   double sum = 0;
   int count =0;
   for (DoubleWritable val : values) {
   
	   System.out.println(val.get());
	   
	    sum += val.get();
        count+=1;
   }
   sum=sum/count;
   System.out.println(count);
   System.out.println(sum);
   //result.set(sum);
   context.write(key, new DoubleWritable(sum));
 }
	  }
	  
	
public static void main(String[] args) throws Exception{
	 Configuration conf = new Configuration();
	    Job job = Job.getInstance(conf, "Sum Tem");
	    job.setJarByClass(NoCombiner.class);
	    job.setMapperClass(YearMapper.class);
	    //job.setCombinerClass(IntSumReducer.class);
	    job.setReducerClass(YearReducer.class);
	    job.setNumReduceTasks(2);
	    job.setOutputKeyClass(IntWritable.class);
	    job.setOutputValueClass(DoubleWritable.class);
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	
}	
	
}
