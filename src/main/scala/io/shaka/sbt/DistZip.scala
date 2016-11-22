package io.shaka.sbt

import sbt.{AutoPlugin, Keys, PluginTrigger, Setting, TaskKey, settingKey, taskKey}

object DistZip extends AutoPlugin{

  override def trigger = allRequirements

  object autoImport {
    val distZip = taskKey[Unit]("Create a distribution zip file")
    val distZipScripts = settingKey[String](
      "sbt-dist-zip scripts directory - defaults to src/main/dist")

  }

  import autoImport._

  override lazy val projectSettings = Seq(
    distZipScripts := "src/main/dist",
    distZip := println(s"#################### The target dir is")
  )

}