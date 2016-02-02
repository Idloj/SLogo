package slogo.parsing

trait Turtle {
  def move(x: Double, y: Double): Unit
  def rotate(deg: Double): Unit
  var heading: Double
}
