package slogo

package object gui {
  def toScreenCoords(x: Double, y: Double, width: Double, height: Double) =
    (width/2 + x, height/2 - y)
}
