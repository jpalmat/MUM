package stripe;


import java.io.IOException;
import java.util.Map.Entry;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Reducer;

public class StripesReducer extends Reducer<Text, MapWritable, Text, Text> {

  @Override
  public void reduce(Text key, Iterable<MapWritable> values, Context context)
      throws IOException, InterruptedException {
	  
	   
	  MapWritable finalList = new MapWritable();
	  
	   for(MapWritable map : values)
	   {
		   for(Entry<Writable, Writable> entry : map.entrySet())
		   {
			   if(finalList.keySet().contains(entry.getKey().toString()))
			   {
				   IntWritable value = (IntWritable) entry.getValue();
				   IntWritable preValue = (IntWritable)finalList.get(entry.getKey());
				   finalList.put(entry.getKey(), new IntWritable(value.get()+preValue.get()));
			   }
			   else
			   {
				   IntWritable value = (IntWritable) entry.getValue();
				   finalList.put(entry.getKey(), new IntWritable(value.get()));
			   }
		   }
		   
	   }
	   context.write(key, format(finalList));

  }
  
  private Text format(MapWritable map)
  {
	  double sum =  0;
	  for(Entry<Writable, Writable> entry : map.entrySet())
	   {
		  IntWritable value = (IntWritable)entry.getValue();
		  sum = sum + value.get();
	   }
	  
	  StringBuilder obj = new StringBuilder();
	  obj.append("[");
	  for(Entry<Writable, Writable> entry : map.entrySet())
	   {
		  IntWritable value = (IntWritable)entry.getValue();
		  double frequency =   (value.get() / sum); 
		  DoubleWritable result = new DoubleWritable(frequency);
		  obj.append("("+ entry.getKey().toString()+","+result.get()+")");		  
	   }
	  obj.append("]");
	  return new Text(obj.toString());
  }
  
}
