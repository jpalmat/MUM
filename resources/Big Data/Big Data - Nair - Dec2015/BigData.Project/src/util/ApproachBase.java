package util;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ApproachBase {
	Class<? extends ApproachBase> apporach;
	Class<? extends Mapper> mapper;
	Class<? extends Reducer>  reducer;
	Class<? extends Partitioner>  partitioner;
	
	public ApproachBase(Class<? extends ApproachBase> a, Class<? extends Mapper> m, 
			Class<? extends Reducer>  r, Class<? extends Partitioner>  p){
		this.apporach = a;
		this.mapper = m;
		this.reducer = r;
		this.partitioner = p;
		
	}
	public Job createJob(String[] args, int numberOfReducers) throws IllegalArgumentException, IOException{
		
		Job job = new Job();
		 
	    job.setJarByClass(apporach);
	    job.setJobName(apporach.getName());
	    
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	   
	    job.setMapperClass(mapper);
	    job.setReducerClass(reducer);
	    job.setPartitionerClass(partitioner);	    
	    
	    job.setNumReduceTasks(numberOfReducers);
	    return job;
	}
}
