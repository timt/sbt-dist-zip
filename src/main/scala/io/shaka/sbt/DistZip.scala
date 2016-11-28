package io.shaka.sbt

import java.io.File

import sbt.{AutoPlugin, Compile, Keys, Path, Scoped, settingKey, taskKey}
import sbt.IO._
import sbt.Path._
import sbt.plugins.JvmPlugin
import sbt.IO

object DistZip extends AutoPlugin{

  override def trigger = allRequirements

  object autoImport {
    val distZipScripts = settingKey[String](
      "sbt-dist-zip scripts directory - defaults to src/main/dist")
    val distZip = taskKey[Unit]("Create a distribution zip file")
  }

  import autoImport._

  override lazy val projectSettings = Seq(
    distZipScripts := "main/dist",
    distZip := {
      val distFilesSrcDir = Keys.sourceDirectory.value / distZipScripts.value
      val targetDir = Keys.target.value
      val jar = (Keys.packageBin in Compile).value
      val distTarget = targetDir / "dist"
      val projectName = Keys.name.value

      IO.copyDirectory(distFilesSrcDir, distTarget)
      IO.copyFile(jar, distTarget / s"${Keys.name.value}.jar")
      IO.zip(allSubpaths(distTarget), targetDir / s"$projectName.zip")
    }
  )

}