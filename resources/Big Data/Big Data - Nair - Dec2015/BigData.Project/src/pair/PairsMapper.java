package pair;


import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import util.Pair;

public class PairsMapper extends Mapper<LongWritable, Text, Pair, IntWritable> {

	HashMap<Pair,Integer> hasMap = null;
	
	public PairsMapper()
	{
		hasMap = new HashMap<Pair,Integer>();
	}
	
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

    String line = value.toString();
    
    String[] lineWords = line.split(" ");    
    for(int i=0;i<lineWords.length;i++)
    {
    	for(int j=i+1; j<lineWords.length;j++)
    	{			
			upsertPair(new Pair(lineWords[i], lineWords[j])); 
			upsertPair(new Pair(lineWords[i],"*"));  
    	}
    }

  }
@Override
protected void cleanup(Context context)
		throws IOException, InterruptedException {
	
	super.cleanup(context);	
	for(Pair p : hasMap.keySet())
	{
		context.write(p, new IntWritable(hasMap.get(p)));
	}
}
 
private Integer upsertPair(Pair p)
{
	if(hasMap.keySet().contains(p))
	{
		return hasMap.put(p, (Integer)hasMap.get(p) + 1);
	}
	else
	{
		return hasMap.put(p,1);
	}
}
  
  
  
}