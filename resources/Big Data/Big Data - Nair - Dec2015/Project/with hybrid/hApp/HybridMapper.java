package hApp;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class HybridMapper extends Mapper<LongWritable, Text, Pair, IntWritable> {

	HashMap<Pair,Integer> ds = null;
	public HybridMapper()
	{
		ds = new HashMap<Pair,Integer>();
	}
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

    String inputLine = value.toString();
    
    String[] lstWords = inputLine.split(" ");
    for(int i=0;i<lstWords.length;i++)
    {
    	for(int j=i+1;j<lstWords.length;j++)
    	{
    		if(lstWords[i].equals(lstWords[j]))
    			break;//Reached the end of the neighborhood
    		else //Iterating over the items in the neighborhood
    		{
    			//upsert = insert + update
    			upsertPair(new Pair(lstWords[i],lstWords[j]));
    		}    		
    	}
    }

  }
@Override
protected void cleanup(Context context)
		throws IOException, InterruptedException {
	// TODO Auto-generated method stub
	super.cleanup(context);
	
	for(Pair p : ds.keySet())
	{
		context.write(p,new IntWritable(ds.get(p)));
	}
}
 
private Integer upsertPair(Pair p)
{
	if(ds.keySet().contains(p))
	{
		return ds.put(p, (Integer)ds.get(p) + 1);
	}
	else
	{
		return ds.put(p,1);
	}
}
  
  
  
}
