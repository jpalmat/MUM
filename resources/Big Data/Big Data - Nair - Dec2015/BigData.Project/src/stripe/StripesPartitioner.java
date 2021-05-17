package stripe;

import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import util.*;

public class StripesPartitioner extends Partitioner<Text, MapWritable> {
	PartitionerBase partitioner;
	
	public StripesPartitioner() {
		partitioner = new PartitionerBase();
	}
	
	@Override
	public int getPartition(Text key, MapWritable value, int numberOfReducers) {
		Integer i = Integer.parseInt(key.toString());
		return partitioner.getPartition(i, numberOfReducers);
	}

}