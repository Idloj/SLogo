package slogo.parsing

class Token
case class Number(num: Double) extends Token
case class Word(str: String)   extends Token
case class Procedure(proc: String)  extends Token

object Parser {
  def tokenize(code: String) = code.split(" ").filter(_.length!=0).toVector map {
    case num if toDouble(num) != None => Number(num.toDouble)
    case str if str.startsWith("\"")  => Word(str drop 1)
    case proc                         => Procedure(proc)
  }
  def run(code: String, turtle: Turtle) = eval(tokenize(code), new Procs(turtle, TurtleProcs.procsMap))
  def eval(tokens: Vector[Token], procs: Procs): (Any, Vector[Token]) = tokens(0) match {
    case Number(num)       => (num, tokens drop 1)
    case Word(str)         => (str, tokens drop 1)
    case Procedure(proc)   => procs.args(proc) match {
      case Some(num) =>
        var res  = (null: Any, tokens drop 1)
        val args = new Array[Any](num)
        0 until num foreach { i =>
          res = try eval(res._2, procs) catch { case _: IndexOutOfBoundsException => throw new NotEnoughArgumentsException }
          args(i) = res._1
        }
        (procs.proc(proc)(args), res._2)
      case None => throw new MissingProcedureException
    }
  }
}
