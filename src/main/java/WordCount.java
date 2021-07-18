import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WordCount {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("wc").setMaster("local");
        JavaSparkContext sparkContext = new JavaSparkContext(conf);
        JavaRDD<String> lineRDD = sparkContext.textFile("wc.txt");

//        JavaRDD<String> wordRDD = lineRDD.flatMap((FlatMapFunction<String, String>) line -> {
//            String[] split = line.split(" ");
//            List<String> list = Arrays.asList(split);
//            return list.iterator();
//        });

        JavaRDD<String> wordRDD = lineRDD.flatMap(x -> Arrays.asList(x.split(" ")).iterator());
        JavaPairRDD<String, Integer> pairRDD = wordRDD.mapToPair(rdd -> new Tuple2<>(rdd, 1));
        JavaPairRDD<String, Integer> reduceByKeyRDD = pairRDD.reduceByKey(Integer::sum);
        reduceByKeyRDD.foreach(rdd -> System.out.println(rdd._1() + " " + rdd._2));
    }
}
