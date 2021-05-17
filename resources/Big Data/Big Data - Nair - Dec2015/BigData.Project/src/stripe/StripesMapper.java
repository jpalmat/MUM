package stripe;


import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StripesMapper extends Mapper<LongWritable, Text, Text, MapWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
	  String line = value.toString();    
	  String[] lineWords = line.split(" ");
	  HashMap<String,Integer> hasMap;
    
    for(int i=0; i<lineWords.length; i++)
    {
    	hasMap = new HashMap<String,Integer>();
    	
    	for(int j=i+1; j<lineWords.length; j++)
    	{
    		if(lineWords[i].equals(lineWords[j]))
    			break;
    		else  
    		{
    			if(hasMap.keySet().contains(lineWords[j]))
    			{
    				hasMap.put(lineWords[j],(Integer)hasMap.get(lineWords[j]) + 1); 
    			}
    			else
    				hasMap.put(lineWords[j], 1); 
    		}    		
    	}    	
    	context.write(new Text(lineWords[i]),format(hasMap));
    }

  }
  
  private MapWritable format(HashMap<String,Integer> hasMap)
  {
	  MapWritable obj = new MapWritable();
	  
	  for(String str: hasMap.keySet())
	  {
		  obj.put(new Text(str), new IntWritable(hasMap.get(str)));
	  }
	  return obj;
  }
  
 
  
}
