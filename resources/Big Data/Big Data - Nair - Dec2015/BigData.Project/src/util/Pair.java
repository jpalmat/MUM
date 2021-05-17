package util;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;


public class Pair implements WritableComparable<Pair>
{
	public Text key;
	public Text value;
	
	public Pair()
	{
		this.key = new Text();
		this.value = new Text();
	}
	public Pair(Text _key,Text _value)
	{
		this.key = _key;
		this.value = _value;
	}
	public Pair(String k,String v)
	{
		this.key = new Text(k);
		this.value = new Text(v);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Pair p = (Pair)obj;
		return p.key.equals(this.key) && p.value.equals(this.value);
	}
	
	@Override
	public int hashCode()
	{
		return key.hashCode() * 13 + value.hashCode();
	}
	
	@Override
	public String toString()
	{
		return key + "," + value;
	}

	@Override
	public void readFields(DataInput input) throws IOException {
		 
		this.key.readFields(input);
		this.value.readFields(input);
	}

	@Override
	public void write(DataOutput output) throws IOException {
		this.key.write(output);
		this.value.write(output);
	}

	@Override
	public int compareTo(Pair p) {
		int result = this.key.compareTo(p.key); 		
		if(result != 0)
			return result;
		else
			return this.value.compareTo(p.value); 
	}
	
}


