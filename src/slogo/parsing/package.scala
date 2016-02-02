package slogo

package object parsing {
  type Proc = Array[Any] => Any

  def toDouble(str: String) = try Some(str.toDouble) catch { case _: Exception => None }
}
