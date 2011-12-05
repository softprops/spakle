object Build extends sbt.Build {
  import sbt._
  lazy val root = Project("root", file("."),
    settings = Defaults.defaultSettings
  ) aggregate(lib, app)
  lazy val lib = Project("library", file("library"))
  lazy val app = Project("app", file("app"),
    settings = Defaults.defaultSettings ++
                         conscript.Harness.conscriptSettings
  ) dependsOn(lib)
}
