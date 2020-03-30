package slogo.parsing

object TurtleProcs {
  val procsMap = new ProcsMap ++ Seq(
    "forward" -> (1, forward),
    "back"    -> (1, back),
    "right"   -> (1, right),
    "left"    -> (1, left))

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
}
