package pair;


import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import util.Pair;

public class PairsReducer extends Reducer<Pair, IntWritable, Pair, DoubleWritable> {
	
	private double count;
	
	public PairsReducer()
	{
		count = 1;
	}
	
  @Override
  public void reduce(Pair p, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
	  
		  double sum = 0;
		  
		  for(IntWritable value : values)
		  {
			  sum = sum + value.get();
		  }
		  
		  if(p.value.toString().equals("*"))
		  {
			   count = sum;
		  }
		  else
		  {
			  context.write(p, new DoubleWritable(sum/count));
		  }
  }
}
