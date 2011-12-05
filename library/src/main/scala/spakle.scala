package spakle

/** A tiny utility for generating spark line graphs */
object Spark {
  val Lines = "▁▂▃▄▅▆▇"
  def lns(pts: Seq[Double]) = {
    val (min, span) = (pts.min, (pts.max - pts.min) / (Lines.size - 1))
    (for { p <- pts } yield { Lines(((p - min) / span).toInt) }) mkString("")
  }
}
