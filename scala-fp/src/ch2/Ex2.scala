package ch2

object Ex2 extends App {

  def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean = as match {
    case _ if as.isEmpty ⇒ true
    case _ ⇒ as.sliding(2).forall { case Array(x, y) ⇒ gt(x,y) }
  }

  val a = Array(1, 2, 3, 6, 4)
  val b = Array(1, 4, 7, 100, 102)
  val c = Array("alice", "bob", "charlie")

  val intComp = (a: Int, b: Int) => (a compareTo b) < 0
  val stringComp = (a: String, b: String) ⇒ (a compare b) < 0

  assert(!isSorted(a, intComp))
  assert(isSorted(b, intComp))
  assert(isSorted(c, stringComp))
}
