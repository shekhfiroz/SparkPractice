package com.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.rdd.RDD;

public class SparkCore {

	private RDD<String> textFile;
	private static SparkCore sparkCore;

	public static void main(String[] args) {
		/* Logger class is use to control the logging 
		 * System.setProperty is use to remove the winutils exceptions in windos os
		 * */
		Logger.getLogger("org").setLevel(Level.INFO);
		//System.setProperty("hadoop.home.dir", "E:\\hadoop2.8\\bin");
		sparkCore = new SparkCore();
		sparkCore.countLines();
	}

	public void countLines() {

		SparkConf config = new SparkConf().setAppName("counLines").setMaster("local[4]");
		SparkContext sparkcontext = new SparkContext(config);
		RDD<String> rddFile = sparkcontext.textFile("Auto.csv", 2);
		rddFile.count();
		System.out.println("FileContent" + " " + rddFile.count());
		// System.out.println("FileContent" + rddFile);
	}

	public void defineExcplitMapper() {
		
		
			
	}

}
