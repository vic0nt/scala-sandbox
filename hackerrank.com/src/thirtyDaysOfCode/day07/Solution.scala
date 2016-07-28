package thirtyDaysOfCode.day07

/**
  * Created by vicont on 28.07.2016.
  */
object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var arr = new Array[Int](n);
    for(arr_i <- 0 to n-1) {
      arr(arr_i) = sc.nextInt();
    }
    for (i <- n-1 to 0 by -1) {
      print(arr(i) + " ")
    }
  }
}