package io.shaka.sbt

import sbt.{AutoPlugin, Keys, Setting, TaskKey}

object DistZip extends AutoPlugin{
  val distTask = TaskKey[Unit]("dist")

  distTask := Keys.target map { (t) =>
    println(s"The target dir is $t")
    ()
  }

  override def globalSettings: Seq[Setting[_]] = super.globalSettings ++ Seq(
    Keys.commands += distTask
  )
}
