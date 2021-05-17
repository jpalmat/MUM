package pair;


import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.IntWritable;

import util.Pair;
import util.PartitionerBase;

public class PairsPartitioner extends Partitioner<Pair, IntWritable> {
	PartitionerBase partitioner;
	
	public PairsPartitioner() {
		partitioner = new PartitionerBase();
	}
	@Override
	public int getPartition(Pair p, IntWritable value, int numberOfReducers) {
		Integer i = Integer.parseInt(p.key.toString());
		return partitioner.getPartition(i, numberOfReducers); 
	}

}

