package slogo

import java.awt._

import gui.MainWindow

object SLogo extends App {
  EventQueue.invokeLater {
    val window = new MainWindow
    window.setVisible(true)
    window.setup()
  }
}
