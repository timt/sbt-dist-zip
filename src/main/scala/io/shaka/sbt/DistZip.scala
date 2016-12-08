package io.shaka.sbt

import sbt._

object DistZip extends AutoPlugin{

  override def trigger = allRequirements

  object autoImport {
    val distZipScripts = settingKey[String](
      "sbt-dist-zip scripts directory - defaults to src/main/dist")
    val distZip = taskKey[Unit]("Create a distribution zip file")
    val distZipArtifactFile = taskKey[File]("sbt-dist-zip task that produces artifact that is to be included in zip")
  }

  import autoImport._

  override lazy val projectSettings = Seq(
    distZipArtifactFile := (Keys.packageBin in Compile).value,
    distZipScripts := "main/dist",
    distZip := {
      val distFilesSrcDir = Keys.sourceDirectory.value / distZipScripts.value
      val targetDir = Keys.target.value
      val jar = distZipArtifactFile.value
      val distTarget = targetDir / "dist"
      val projectName = Keys.name.value

      IO.copyDirectory(distFilesSrcDir, distTarget)
      IO.copyFile(jar, distTarget / s"${Keys.name.value}.jar")
      IO.zip(allSubpaths(distTarget), targetDir / s"$projectName.zip")
    }
  )

}