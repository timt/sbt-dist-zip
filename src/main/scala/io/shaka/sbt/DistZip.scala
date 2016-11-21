package io.shaka.sbt

import sbt.{AutoPlugin, Keys, Setting, TaskKey}

object DistZip extends AutoPlugin{

  object autoImport {
    lazy val distTask = TaskKey[Unit]("dist")
  }

  import autoImport._

  override lazy val projectSettings = Seq(
    distTask := Keys.target map { (t) =>
      println(s"The target dir is $t")
      ()
    }
  )

}
