package nativeclass;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class Application {

	public static void main(String[] args) {

		Application application = new Application();
		application.actionandtransformation();

	}

	public void actionandtransformation() {
		SparkConf sparkconf = new SparkConf().setMaster("local").setAppName("Transformation & Actions");
		JavaSparkContext javasparkcontext = new JavaSparkContext(sparkconf);
		java.util.List<Integer> listdata = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9, 11, 12, 13, 14, 15, 16, 0, 17, 18, 29);

		long distData = javasparkcontext.parallelize(listdata).count();
		System.out.println("Printing Count of All Element of Array==" + distData);

		long firstElement = javasparkcontext.parallelize(listdata).first();
		System.out.println("Printing firstElements==" + firstElement);
		//
		// long takeFUnction = javasparkcontext.parallelize(listdata).max();
		// System.out.println("Printing take Function==" + takeFUnction);
		//
		// to print all elements
		List<Integer> allElement = javasparkcontext.parallelize(listdata).collect();
		{
			System.out.println("Print All Elements==" + allElement);
		}
	}
}