package spakle

/** Provide a convenient way to access piped input args */
object Piped {
  import java.io.{ BufferedReader, InputStreamReader }

  /** read any piped input into a seq of string args */
  def arguments =
    System.in.available match {
      case none if(none < 1) => Seq.empty[String]
      case some =>
        @annotation.tailrec
        def read(args: Seq[String])(r: BufferedReader): Seq[String] =
          r.readLine() match {
            case null => args.reverse
            case line => read(line +: args)(r)
          }
        using(new BufferedReader(new InputStreamReader(System.in))) {
          read(Seq.empty[String])
        }
    }

  private def using[C <: { def close(): Unit }, T](c: C)(f: C => T): T =
    try { f(c) }
    finally { c.close }
}
