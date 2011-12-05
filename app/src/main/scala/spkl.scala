package spakle

object Spkl {
  import scala.util.control.Exception.allCatch

  val Usage =
    """
    | spkl <n1> [<n2> ...]
    |
    | ▁▂▃▄▅▆
    | spkl prints sparkline graphs from space-delimited data points
    """.stripMargin

  def main(args: Array[String]) {
    System.exit(run(args))
  }

  def run(args: Array[String]) = {
    val (out, stat) = args match {
      case e if(e.isEmpty) => (Usage, 1)
      case ary =>
        (allCatch.either { Spark.lns(ary map(_.toDouble)) })
          .fold({ e => (Usage, 1) }, { (_, 0) })
    }
    println(out)
    stat
  }
}
