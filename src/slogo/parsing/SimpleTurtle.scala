package slogo.parsing

class SimpleTurtle(var x: Double, var y: Double, var heading: Double) extends Turtle {
  def move(x: Double, y: Double) = { this.x+=x; this.y+=y }
  def rotate(deg: Double) = { heading+=deg }
  override def toString = s"SimpleTurtle($x, $y, $heading)"
}
