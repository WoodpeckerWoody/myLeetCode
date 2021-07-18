import org.apache.spark.Partition;
import org.apache.spark.SparkConf;
import org.apache.spark.TaskContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.rdd.RDD;
import scala.Tuple2;
import scala.collection.Iterator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaWordCount {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("JavaWordCount");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> str =new ArrayList<>();
        str.add(list);
        List<Integer> list1 = new ArrayList<>();
        list1.add(8);
        list1.add(9);
        JavaRDD<Integer> parallelize1 = jsc.parallelize(list);
        JavaRDD<Integer> parallelize2 = jsc.parallelize(list);
        str.add(list1);
        String[] words = new String[]{"Hello","World"};
        List<String[]> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());

        List<String> collect = Stream.of(words).flatMap(s -> Stream.of(s.split(""))).collect(Collectors.toList());
//        List<String> collect = Stream.of(words).flatMap(word -> Stream.of(word.split(""))).collect(toList());

//        parallelize1.flatMap(v -> v++);
        System.out.println(collect);


//        JavaRDD<String> lines = jsc.textFile("C:\\Users\\YellowForest\\Desktop\\test.txt");
//        JavaRDD<String> words = lines.flatMap((FlatMapFunction<String, String>) line -> Arrays.asList(line.split(" ")).iterator());
//
//        JavaPairRDD<String, Integer> wordsone = words.mapToPair((PairFunction<String, String, Integer>) word -> new Tuple2<>(word, 1));
//        JavaPairRDD<String, Integer> redeced = wordsone.reduceByKey((Function2<Integer, Integer, Integer>) Integer::sum);
//        JavaPairRDD<Integer, String> swapt = redeced.mapToPair((PairFunction<Tuple2<String, Integer>, Integer, String>) Tuple2::swap);
//
//        JavaPairRDD<Integer, String> sorted = swapt.sortByKey(false);
//        sorted.saveAsTextFile("C:\\Users\\YellowForest\\Desktop\\dd");
        jsc.stop();


    }

}
