package thirtyDaysOfCode.day10

object Solution {
  def main(args: Array[String]) {

    def anesCounter(l: List[Int], totalQty: Int, currQty: Int): Int = {
      println(l, "   ",totalQty, " ", currQty)
      l match {
        case Nil => totalQty
        case head :: Nil => totalQty
        case head :: tail => if (head == 1 && tail.head == 1) anesCounter(tail, totalQty + 2, currQty + 2)
          else if (head == 1 && tail.head == 0) anesCounter(tail, List(totalQty, currQty).max, 0)
          else anesCounter(tail, totalQty, 0)
      }
    }

    val list: List[Int] = io.StdIn.readInt().toBinaryString.split("").map(c => if (c=="1") 1 else 0).toList
    val rez = if (list.contains(1)) anesCounter(list,0,0) else 0
    println(rez)
  }
}
