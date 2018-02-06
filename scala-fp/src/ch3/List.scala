package ch3

import scala.annotation.tailrec

sealed trait List[+A]

case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def drop[A](list: List[A], n: Int): List[A] =
    if (n <= 0) list else list match {
    case Nil => Nil
    case Cons(_, xs) => drop(xs, n-1)
  }

  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(x, xs) => if (f(x)) dropWhile(xs)(f) else l
  }

  def setHead[A](l: List[A])(head: A): List[A] = l match {
    case Nil => Nil
    case Cons(_, xs) => Cons(head, xs)
  }

  def foldRight[A,B](l: List[A], z: B)(f: (A, B) => B): B =
    l match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  @tailrec
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => foldLeft(xs, f(z,x))(f)
  }

  /* cheating */
  def foldRight2[A,B](as: List[A], z: B)(f: (A, B) => B): B = foldLeft(reverse(as),z)((a,b) ⇒ f(b,a))

  def append[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil => a2
      case Cons(h,t) => Cons(h, append(t, a2))
    }

  def append2[A](a1: List[A], a2: List[A]): List[A] = foldRight(a1, a2)((el, list) ⇒ Cons(el,list))

  def init[A](l: List[A]): List[A] =
    l match {
      case Nil ⇒ l
      case Cons(x, Cons(_, Nil)) ⇒ Cons(x, Nil)
      case Cons(x, xs) ⇒ Cons(x, init(xs))
    }

  def length[A](as: List[A]): Int = foldRight(as,0)((_,b) ⇒ b + 1)

  def reverse[A](as: List[A]): List[A] = foldLeft(as, Nil:List[A])((a,b) ⇒ Cons(b,a))

  def concatenate[A](as: List[List[A]]): List[A] = foldRight(as, Nil:List[A])(append)

  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = List(1, 2, 3)
  val total = sum(example)
}