package dsa

/**
  * Created by vicont on 09.10.2016.
  */

sealed trait MyList[+A] {
  def reverse = {
    @annotation.tailrec
    def reverse_[A](xs: MyList[A], acc: MyList[A]): MyList[A] = {
      xs match {
        case Empty          => acc
        case Node(v, next)  => reverse_(next, Node(v, acc))
      }
    }
    reverse_(this, Empty)
  }
}

case object Empty extends MyList[Nothing]
case class Node[A](value: A, next: MyList[A]) extends MyList[A]

object Launcher extends App {
  Node(1, Node(2, Node(3, Empty))).reverse
  Empty.reverse
}