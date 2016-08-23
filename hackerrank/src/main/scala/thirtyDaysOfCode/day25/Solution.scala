package thirtyDaysOfCode.day25

/**
  * Created by vicont on 23.08.2016.
  */
object Solution {

  def isPrime(n: Int) =
    if (n == 1) "Not prime"
    else if (n > 1 && (Iterator.from(2) takeWhile (i => i < Math.sqrt(n).toInt) exists (n % _ == 0))) "Not prime" else "Prime"

  def main(args: Array[String]) {
    val in = new java.util.Scanner(System.in)
    val n = in.nextInt()
    val numbers = (for (_ <- 1 to n) yield in.next()).map(Integer.parseInt)
    numbers.map(isPrime).foreach(println)
  }
}
