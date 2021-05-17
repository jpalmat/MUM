
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WithCombiner {

	  public static class YearMapper
      extends Mapper<Object, Text, IntWritable, Pair>{
     
		  Map<Integer,Pair> keeper ;
		  
		private  String  localLine=null;

   public void map(Object key, Text value, Context context
                   ) throws IOException, InterruptedException {
	   
	     localLine=value.toString();
	   int mapKey=Integer.parseInt(localLine.substring(15, 23));
	   
	   double mapValue=Double.parseDouble(localLine.substring(87,92))/10;
	   
	   System.out.println(mapValue);
	   if(keeper==null) keeper = new HashMap();
	   if(keeper.containsKey(mapKey)){
		   
		  Pair p=keeper.get(mapKey);
		  
		   Double newVal =p.getSum() +mapValue;
		   int newCount =p.getCount()+1;
		   p.setSum(newVal);
           p.setCount(newCount);
		   keeper.put(mapKey, p);
		   
		}
	   else {
		   Pair p= new Pair(mapValue,1);
		   keeper.put(mapKey, p);}
	   System.out.println(keeper.size());
	   
	   
	   
   }
  
   
   protected void cleanup(Context context)
		   throws IOException, InterruptedException {
	   
     System.out.println("done");
	  Iterator<Map.Entry<Integer, Pair>> it = keeper.entrySet().iterator();
	     while(it.hasNext()) {
	    Entry<Integer, Pair> entry = it.next();
	    Integer sKey = entry.getKey();
	    // int total = entry.getValue().intValue();
	   // context.write(new Text(sKey), new IntWritable(total));
	    
	   System.out.println(sKey );
	   System.out.println(entry.getValue().getSum() );
	   System.out.println(entry.getValue().getCount() );
	   context.write(new IntWritable(sKey), entry.getValue());
		  }
   
 }
	  }  
	  public static class YearReducer
      extends Reducer<IntWritable,Pair,IntWritable,DoubleWritable>
	  {
		  private DoubleWritable result = new DoubleWritable();

		  
		  public void reduce(IntWritable key, Iterable<Pair> values,
                    Context context
                    ) throws IOException, InterruptedException {
  double sum = 0;
   int count =0;
   for (Pair val : values) {
     sum += val.getSum();
     count+=val.getCount();
   }
   sum=sum/count;
   result.set(sum);
   context.write(key, result);
 }
	  }
	  
	  
	public static void main(String[] args) throws Exception {
	
		 Configuration conf = new Configuration();
		    Job job = Job.getInstance(conf, "Sum Temm");
		    job.setJarByClass(WithCombiner.class);
		    job.setMapperClass(YearMapper.class);
		    //job.setCombinerClass(IntSumReducer.class);
		    job.setReducerClass(YearReducer.class);
		    job.setNumReduceTasks(2);
		    job.setOutputKeyClass(IntWritable.class);
		    job.setOutputValueClass(Pair.class);
		    job.setMapOutputValueClass(Pair.class);
		    FileInputFormat.addInputPath(job, new Path(args[0]));
		    FileOutputFormat.setOutputPath(job, new Path(args[1]));
		    System.exit(job.waitForCompletion(true) ? 0 : 1);
		
		
		
		//extract();
		
		
		
		
	}

	
	
}
