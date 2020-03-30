package slogo.gui

import java.awt._
import java.awt.event._
import javax.swing._

class Canvas extends JPanel {
  private var penLayer    = null: Image
  private var turtleLayer = null: Image

  private val turtle = new Turtle

  addComponentListener(new ComponentAdapter {
    override def componentResized(e: ComponentEvent) = {
      penLayer = createImage(getWidth, getHeight)
      turtleLayer = createImage(getWidth, getHeight)
      drawTurtle()
    }
  })

  override def paintComponent(g: Graphics) = {
    
    g.fillRect(0, 0, getWidth, getHeight)
    g.drawImage(penLayer, 0, 0, null)
    g.drawImage(turtleLayer, 0, 0, null)
  }

  private def drawTurtle() = {
    val points = Array((-3, 0), (3, 0), (0, 10)).
      map { case (x, y) => toScreenCoords(turtle.x + x, turtle.y + y, getWidth, getHeight) }.
      map { case (x, y) => (x.toInt, y.toInt) }
    turtleLayer.getGraphics.clearRect(0, 0, getWidth, getHeight)
    turtleLayer.getGraphics.setColor(Color.WHITE)
    turtleLayer.getGraphics.drawPolygon(points map (p => p._1), points map (p => p._2), 3)
  }
}
