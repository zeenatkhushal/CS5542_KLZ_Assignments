import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkContext, SparkConf}



object SparkTransformation {
  def main(args: Array[String]): Unit = {


    System.setProperty("hadoop.home.dir","C:/winutils")
   // val SparkConf = new SparkConf().setAppName("Your Application Name").setMaster("local")


    val spark = SparkSession
    .builder()
     .master("local")
     .appName("Spark SQL basic example")
     .config("spark.some.config.option", "some-value")
      .getOrCreate()

   // val df = spark.read.format("DATA").load("F:/u.DATA")

//    val df = spark.read.textFile("F:/u.data")
//    df.printSchema()

//    val nums = sc.parallelize(Array(1, 2, 3))
//    // Pass each element through a function
//    val squares = nums.map(x => (x * x)) // => {1, 4, 9}
//
//    // Keep elements passing a predicate
//    val even = squares.filter(x => x % 2 == 0) // => {4}
//
//
//
//    // Map each element to zero or more others
//    val result = nums.flatMap(x => Array.range(0, x)) //=> {0, 0, 1, 0, 1, 2}
//
//    result.foreach(println(_))

//   val df = spark.read.json("F:/people.json")
//    df.groupBy("age").count().filter("`count` > 1").show()
    val df = spark.read.format("com.databricks.spark.csv").option("delimiter", "\t").load("F:/u.data")
    df.sort("_c0").groupBy("_c0").count().filter("`count` > 25").show()








  }

}
