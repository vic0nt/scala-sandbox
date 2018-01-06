package ch2

object Ex3 extends App {
  def partial1[A,B,C](a: A, f: (A,B) ⇒ C): B ⇒ C = (b: B) ⇒ f(a, b)
  def curry[A,B,C](f: (A, B) ⇒ C): A ⇒ (B ⇒ C) = (a: A) ⇒ (b: B) ⇒ f(a,b)
}
