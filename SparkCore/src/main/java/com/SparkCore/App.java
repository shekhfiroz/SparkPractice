package com.SparkCore;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.rdd.RDD;

public class App {

	public static void main(String[] args) {
		System.out.println("Hello spark i m from main class");
		App app = new App();
		app.countLines();
	}

	public void countLines() {
		SparkConf sparkconf = new SparkConf().setAppName("countLines").setMaster("local");
		SparkContext sparkcontext = new SparkContext(sparkconf);
		RDD<String>textFileRdd =sparkcontext.textFile("Auto.csv",2);
		System.out.println(textFileRdd.count());
		//RDD<Integer>countRdd=textFileRdd.map(s->s.length());

	}
}
