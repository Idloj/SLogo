package slogo

import java.awt._

import gui.MainWindow

object SLogo extends App {
  EventQueue.invokeLater(new MainWindow().setVisible(true))
}
