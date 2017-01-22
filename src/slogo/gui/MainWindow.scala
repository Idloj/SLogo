package slogo.gui

import java.awt._
import javax.swing._

class MainWindow extends JFrame("SLogo") {
  setSize(400, 300)
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  val splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new Canvas, new Editor)
  add(splitPane)
  def setup() = {
    splitPane.setDividerLocation(0.8)
  }
}
