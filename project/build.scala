object Build extends sbt.Build {
  import sbt._
  import sbt.Keys._

  def shared = Defaults.defaultSettings ++ Seq(
    publishTo := Some(
      Resolver.file("lessis repo", new java.io.File("/var/www/repo"))
    ),
    version := "0.1.0-SNAPSHOT"
  )

  lazy val root = Project("root", file("."), settings = shared) aggregate(lib, app)
  lazy val lib = Project("library", file("library"), settings = shared)
  lazy val app = Project("app", file("app"),
    settings = shared ++ conscript.Harness.conscriptSettings
  ) dependsOn(lib)
}
