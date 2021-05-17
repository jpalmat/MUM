package hybrid;
import util.*;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.IntWritable;


public class HybridPartitioner extends Partitioner<Pair, IntWritable> {
	PartitionerBase partitioner;
	
	public HybridPartitioner() {
		partitioner = new PartitionerBase();
	}
	@Override
	public int getPartition(Pair p, IntWritable value, int numberOfReducers) {
		Integer i = Integer.parseInt(p.key.toString());		
		return partitioner.getPartition(i, numberOfReducers); 	 
	}

}


