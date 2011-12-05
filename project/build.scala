object Build extends sbt.Build {
  import sbt._
  import sbt.Keys._
  import ls.Plugin._

  def shared = Defaults.defaultSettings ++ Seq(
    publishTo := Some(
      Resolver.file("lessis repo", new java.io.File("/var/www/repo"))
    ),
    organization := "me.lessis",
    version := "0.1.0"
  )

  lazy val root = Project("root", file("."), settings = shared) aggregate(lib, app)
  lazy val lib = Project("library", file("library"),
    settings = shared ++ Seq(
     name := "spakle"
    ) ++ lsSettings ++ Seq(
      LsKeys.tags in LsKeys.lsync := Seq("sparkline", "graphs"),
      description in LsKeys.lsync := "A little library for generating sparkline graphs",
      externalResolvers in LsKeys.lsync += "less is" at "http://repo.lessis.me"
    )
  )
  lazy val app = Project("app", file("app"),
    settings = shared ++ conscript.Harness.conscriptSettings ++ Seq(
      name := "spakle-app"
    ) 
  ) dependsOn(lib)
}
