package pairsApp;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class PairsReducer extends Reducer<Pair, IntWritable, Pair, DoubleWritable> {
	
	private double count;
	
	public PairsReducer()
	{
		count = 1;
	}
	
  @Override
  public void reduce(Pair key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
	  
		  double sum = 0;
		  
		  for(IntWritable value : values)
		  {
			  sum = sum + value.get();
		  }
		  
		  if(key.v.toString().equals("*"))
		  {
			   count = sum;
		  }
		  else
		  {
			  context.write(key,new DoubleWritable(sum/count));
		  }
  }
}