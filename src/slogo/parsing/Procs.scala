package slogo.parsing

import scala.math._

class Procs(turtle: Turtle) {
  val procs = Map[String, (Int, Proc)](
    "forward" -> (1, forward),
    "back"    -> (1, back),
    "right"   -> (1, right),
    "left"    -> (1, left),
    "max"     -> (2, max),
    "min"     -> (2, min))
  def syntax(proc: String): Option[Int] = (procs get proc) map (p => p._1)
  def proc(proc: String): Proc = procs(proc)._2

  protected def forward(args: Array[Any]) = args(0) match {
    case arg: Double => turtle.move(arg*sin(toRadians(turtle.heading)), arg*cos(toRadians(turtle.heading)))
    case _ => throw new IllegalArgumentException
  }

  protected def back(args: Array[Any]) = args(0) match {
    case arg: Double => forward(Array(-arg))
    case _ => throw new IllegalArgumentException
  }

  protected def right(args: Array[Any]) = args(0) match {
    case arg: Double => turtle.heading += arg
    case _ => throw new IllegalArgumentException
  }

  protected def left(args: Array[Any]) = args(0) match {
    case arg: Double => right(Array(-arg))
    case _ => throw new IllegalArgumentException
  }

  protected def max(args: Array[Any]) = args match {
    case Array(a: Double, b: Double) => math.max(a, b)
    case _ => throw new IllegalArgumentException
  }

  protected def min(args: Array[Any]) = args match {
    case Array(a: Double, b: Double) => math.min(a, b)
    case _ => throw new IllegalArgumentException
  }
}
