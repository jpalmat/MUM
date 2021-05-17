package sparkPackage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class UserSummarize {

	public static void main(String[] args) {
		// Create a Spark Context.
		SparkConf conf = new SparkConf().setAppName("User Summarize")
				.setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);

		/*
		 * for (String arg : args) { System.out.println("arg: " + arg); }
		 */

		if (args.length != 2) {
			System.out.println("Must specify an input file.");
			System.out.println("[Usage]: "
					+ UserSummarize.class.getSimpleName()
					+ ".jar [inout path] [output file path]");
			System.exit(-1);
		}
		// Load the text file into Spark.
		String logFile = args[0];

		String outputFileTopCustomersTimeElapsed = args[1];

		Configuration hadoopConf = new Configuration();
		FileSystem hdfs = null;

		try {
			hdfs = FileSystem.get(new java.net.URI("hdfs://localhost:8020"),
					hadoopConf);

			Path output = new Path(outputFileTopCustomersTimeElapsed);

		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JavaRDD<String> logLines = sc.textFile(logFile);

		// Convert the user data lines to user objects and cache them
		// since multiple transformations and actions will be called on that
		// data.
		JavaRDD<User> users = logLines.map(Functions.PARSE_USER_LINE)
				.cache();

		List<Tuple2<Integer, String>> topTenCustomerTimeElapsedList = users
				.mapToPair(new PairFunction<User, String, Integer>() {
					private static final long serialVersionUID = 1L;

					@Override
					public Tuple2<String, Integer> call(User user)
							throws Exception {
						return new Tuple2<String, Integer>(user
								.getFirstName() + " " + user.getLastName(),
								user.getTimeElapsed());
					}
				})
				.reduceByKey(new Function2<Integer, Integer, Integer>() {

					private static final long serialVersionUID = 1L;

					@Override
					public Integer call(Integer v1, Integer v2)
							throws Exception {
						return v1 + v2;
					}
				})
				.mapToPair(
						new PairFunction<Tuple2<String, Integer>, Integer, String>() {
							private static final long serialVersionUID = 305463067298325558L;

							@Override
							public Tuple2<Integer, String> call(
									Tuple2<String, Integer> t) throws Exception {
								return new Tuple2<Integer, String>(t._2, t._1);
							}
						}).sortByKey(false).take(5);

		JavaPairRDD<String, Integer> top5UserTimeElapsedRDD = sc
				.parallelizePairs(topTenCustomerTimeElapsedList)
				.mapToPair(
						new PairFunction<Tuple2<Integer, String>, String, Integer>() {
							private static final long serialVersionUID = 1751116365084634849L;

							@Override
							public Tuple2<String, Integer> call(
									Tuple2<Integer, String> t) throws Exception {
								return new Tuple2<String, Integer>(t._2, t._1);
							}
						});

		List<Tuple2<String, Integer>> top5UserTimeElapsed = top5UserTimeElapsedRDD
				.take(5);

		System.out.println("Top 5 Time Elapsed Customers : ");

		for (Tuple2<String, Integer> tuple : top5UserTimeElapsed) {
			System.out.println(tuple);
		}
		// write to file
		top5UserTimeElapsedRDD
				.saveAsTextFile(outputFileTopCustomersTimeElapsed);

		sc.close();
	}

}
