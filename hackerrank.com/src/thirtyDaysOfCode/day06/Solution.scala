package thirtyDaysOfCode.day06

/**
  * Created by ruatvv2 on 26.07.16.
  */
object Solution {

  def main(args: Array[String]) {
    val lines = io.Source.stdin.getLines
    for (s <- lines.drop(1)) {
      val odds = s.zipWithIndex.filter(_._2 % 2 == 0).map(_._1).mkString("")
      val evens = s.zipWithIndex.filter(_._2 % 2 == 1).map(_._1).mkString("")
      println(s"$odds $evens")
    }
  }
}
