package stripApp;

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
 
	  /* [cat,mat,rat,cat]
	   * 
	   * cat,[(mat,1),(rat,1)]
	   * mat,[(rat,1),(cat,1)]
	   * rat,[(cat,1)]
	   * 
	   */
    String inputLine = value.toString();
    
    String[] lstWords = inputLine.split(" ");
    HashMap<String,Integer> ds;
    for(int i=0;i<lstWords.length;i++)
    {
    	ds = new HashMap<String,Integer>();
    	for(int j=i+1;j<lstWords.length;j++)
    	{
    		if(lstWords[i].equals(lstWords[j]))
    			break;//Reached the end of the neighborhood
    		else //Iterating over the items in the neighborhood
    		{
    			if(ds.keySet().contains(lstWords[j]))
    			{
    				ds.put(lstWords[j],(Integer)ds.get(lstWords[j]) + 1); 
    			}
    			else
    				ds.put(lstWords[j],1); 
    		}    		
    	}
    	
    	context.write(new Text(lstWords[i]),format(ds));
    }

  }
  
  private MapWritable format(HashMap<String,Integer> ds)
  {
	  MapWritable obj = new MapWritable();
	  
	  for(String s: ds.keySet())
	  {
		  obj.put(new Text(s), new IntWritable(ds.get(s)));
	  }
	  return obj;
  }
  
 
  
}
