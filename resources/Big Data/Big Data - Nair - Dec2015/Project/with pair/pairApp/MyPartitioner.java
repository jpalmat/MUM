package pairsApp;

import org.apache.hadoop.mapreduce.Partitioner;

import org.apache.hadoop.io.IntWritable;


public class MyPartitioner extends Partitioner<Pair, IntWritable> {

	@Override
	public int getPartition(Pair key, IntWritable value, int numberOfReducers) {
		
		Integer i = Integer.parseInt(key.k.toString());
		
		if(i<30)
			return 0;
		else if(i>30 && i<60)
			return 1%numberOfReducers;
		else
			return 2%numberOfReducers;
		
		 
	}

}
