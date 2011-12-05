# spakle

("sparkle" pronounced like a new yorker)

A tribute to [@holman's][holman] awesome [spark][spark] script in scala.

## usage

    
    

## install

### via conscript

Install a cmd line client, `spkl` using [conscript][conscript]

    $ cs softprops/spakle
    
Then just toss it some data points

    $ seq 0 28 | sort -r | spkl
    ▂▂▂▂▂▁▁▇▆▆▆▆▅▅▅▅▁▅▄▄▄▄▄▃▃▃▃▁▁

### via sbt

If you are using [ls][ls] just type the following in your `sbt` shell

    sbt> ls-install spakle

Otherwise add it as a library dependency

    libraryDependencies += "me.lessis" %% "spakle" % "0.1.0"
    
    resolvers += "less is" at "http://repo.lessis.me"

And use it as you would any other library

    println(spakle.Spark.lns(util.Random.shuffle((1 to 15).toSeq) map(_.toDouble)))
    ▁▇▁▄▃▂▄▄▆▆▅▃▅▁▂

[holman]: https://github.com/holman
[spark]: https://github.com/holman/spark
[conscript]: https://github.com/n8han/conscript#readme
[ls]: https://github.com/softprops/ls#readme
