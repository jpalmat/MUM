package hApp;

import java.io.IOException;
import java.util.HashMap;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class HybridReducer extends Reducer<Pair, IntWritable, Text, Text> {
	
	private String prevValue;
	
	private HashMap<String,Integer> ds;
	
	public HybridReducer()
	{
		prevValue = null;
		
		ds = new HashMap<String,Integer>();
		
	}
	
  @Override
  public void reduce(Pair key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
	  
		  Integer sum = 0;
		  
		  //1. Sum all values
		  for(IntWritable value : values)
		  {
			  sum = sum + value.get();
		  }
		  
		  if(key.k.toString().equals(prevValue) || prevValue==null)
		  {
			 //Keep building hashmap
			  upsert(key,sum);
		  }
		  else
		  {
			  context.write(new Text(prevValue), format(ds));
			  ds = new HashMap<String,Integer>();
			  upsert(key,sum);
		  }
		  prevValue = key.k.toString();
		  
  }
  
  @Override
protected void cleanup(Context context) throws IOException,
		InterruptedException {
	  context.write(new Text(prevValue), format(ds));
}

private void upsert(Pair p, Integer value)
  {
  	if(ds.keySet().contains(p.v.toString()))
  	{
  		ds.put(p.v.toString(),(Integer)ds.get(p.v.toString()) + value);
  	}
  	else
  	{
  		ds.put(p.v.toString(),1);
  	}
  }
  private Text format(HashMap<String,Integer> m)
  {
	  double sum =  0;
	  for(String s : m.keySet())
	   {
		  sum = sum + m.get(s);
	   }
	  StringBuilder obj = new StringBuilder();
	  obj.append("[");
	  for(String s : m.keySet())
	   {
		  double frequency =   (m.get(s) / sum); 
		  DoubleWritable result = new DoubleWritable(frequency);
		  obj.append("("+s+","+result.get()+")");		  
	   }
	  obj.append("]");
	  return new Text(obj.toString());
  }
}