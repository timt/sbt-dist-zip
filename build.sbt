import scala.util.Try
sbtPlugin := true

name := "sbt-dist-zip"

organization := "io.shaka"

version := Try(sys.env("LIB_VERSION")).getOrElse("1")
