package object slogo {
  implicit def code2runnable(fn: => Unit) = new Runnable { def run() = fn }
}
