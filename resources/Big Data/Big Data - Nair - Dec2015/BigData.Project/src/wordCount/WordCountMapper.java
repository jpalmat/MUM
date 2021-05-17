package wordCount;
import java.io.IOException;

import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.io.*;

public class WordCountMapper extends MapReduceBase 
	implements Mapper<IntWritable, Text, Text, IntWritable>{

	@Override
	public void map(IntWritable key, Text value,
			OutputCollector<Text, IntWritable> output, Reporter r)
			throws IOException {
		
		String s = value.toString();
		for(String word: s.split(" ")){
			if(word.length()>0){
				output.collect(new Text(word), new IntWritable(1));
			}
		}
	}
}
