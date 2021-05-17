package hybrid;

import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Writable;

public class myMapWritable extends MapWritable {

	public myMapWritable() {
		super();
	}

	@Override
	public String toString() {
		String out = "[";
		for (Entry<Writable, Writable> entry : this.entrySet()) {
			out += String.format("(%s, %s), ", entry.getKey().toString(), entry
					.getValue().toString());
		}
		return out + "]";
	}

}
