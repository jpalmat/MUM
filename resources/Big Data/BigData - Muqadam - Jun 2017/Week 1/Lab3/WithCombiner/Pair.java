import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;


public class Pair implements Writable {
	
	double sum;
	int count;
	public Pair(){}
	@Override
	public void readFields(DataInput in) throws IOException {
		sum =in.readDouble();
        count =in.readInt();
        
		
	}
	public Pair(double sum,int count){
		this.sum=sum;this.count=count;
	}
	@Override
	public void write(DataOutput out) throws IOException {
		
      out.writeDouble(sum);
      out.writeInt(count);
		
	}


	
	@Override
	public String toString() {
		return "Pair [sum=" + sum + ", count=" + count + "]";
	}
	
	
	
	public double getSum() {
		return sum;
	}
	public int getCount() {
		return count;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
	
	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		long temp;
		temp = Double.doubleToLongBits(sum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (count != other.count)
			return false;
		if (Double.doubleToLongBits(sum) != Double.doubleToLongBits(other.sum))
			return false;
		return true;
	}

	
	
}
