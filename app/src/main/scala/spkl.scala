package spakle

object Spkl {
  import scala.util.control.Exception.allCatch

  val Usage =
    """spkl prints sparkline graphs from space-delimited data points
    |
    | spkl <n1> [<n2> ...]
    |
    | ▁▂▃▄▅▆""".stripMargin

  def main(args: Array[String]) {
    System.exit(run(args))
  }

  def run(args: Array[String]) = {
    val (out, stat) = Piped.arguments ++ args match {
      case e if(e.isEmpty) => (Usage, 1)
      case ary =>
        (allCatch.either { Spark.lns(ary map(_.toDouble)) })
          .fold({ e => (Usage, 1) }, { (_, 0) })
    }
    new java.io.PrintStream(System.out, true, "utf8").println(out)
    stat
  }
}

class Spkl extends xsbti.AppMain {
  def run(config: xsbti.AppConfiguration) =
    new Exit(Spkl.run(config.arguments))
}
class Exit(val code: Int) extends xsbti.Exit
