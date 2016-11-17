package io.shaka.sbt

import sbt.{AutoPlugin, Keys, TaskKey}

object DistZip extends AutoPlugin{
  val distTask = TaskKey[Unit]("dist")

  distTask := Keys.target map { (t) =>
    println(s"The target dir is $t")
    ()
  }
}
