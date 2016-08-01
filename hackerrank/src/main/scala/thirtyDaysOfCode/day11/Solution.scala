package thirtyDaysOfCode.day11

object Solution {
  def main(args: Array[String]) {

    def hourglassSum(a: Array[Array[Int]]) = a.flatten.zipWithIndex.filter(e => e._2 != 3 || e._2 != 5).map(e => e._1).sum


    val arr = Array.ofDim[Int](3,3)
    arr(0)(0) = 2
    arr(0)(1) = 4
    arr(0)(2) = 4
    arr(1)(0) = 0
    arr(1)(1) = 2
    arr(1)(2) = 0
    arr(2)(0) = 1
    arr(2)(1) = 2
    arr(2)(2) = 4

    //print(hourglassSum(arr))
  }
}
