package hybrid;
import java.io.IOException;
import java.util.HashMap;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import util.*;

public class HybridReducer extends Reducer<Pair, IntWritable, Text, Text> {
	
	private String val;
	
	private HashMap<String,Integer> hashMap;
	
	public HybridReducer()
	{
		val = null;		
		hashMap = new HashMap<String,Integer>();
		
	}
	
  @Override
  public void reduce(Pair p, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
	  
		  Integer sum = 0;
		  for(IntWritable value : values)
		  {
			  sum = sum + value.get();
		  }
		  
		  if(p.key.toString().equals(val) || val==null)
		  {
			  upsert(p,sum);
		  }
		  else
		  {
			  context.write(new Text(val), format(hashMap));
			  hashMap = new HashMap<String,Integer>();
			  upsert(p,sum);
		  }
		  val = p.key.toString();
		  
  }
  
  @Override
protected void cleanup(Context context) throws IOException,
		InterruptedException {
	  context.write(new Text(val), format(hashMap));
}

private void upsert(Pair p, Integer value)
  {
  	if(hashMap.keySet().contains(p.value.toString()))
  	{
  		hashMap.put(p.value.toString(),(Integer)hashMap.get(p.value.toString()) + value);
  	}
  	else
  	{
  		hashMap.put(p.value.toString(),1);
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
	  for(String str : m.keySet())
	   {
		  double frequency =   (m.get(str) / sum); 
		  DoubleWritable result = new DoubleWritable(frequency);
		  obj.append("("+str+","+result.get()+")");		  
	   }
	  obj.append("]");
	  return new Text(obj.toString());
  }
}