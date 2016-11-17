import scala.util.Try
sbtPlugin := true

name := "sbt-dist-zip"

organization := "io.shaka"

version := Try(sys.env("LIB_VERSION")).getOrElse("1")

pgpPassphrase := Some(Try(sys.env("SECRET")).getOrElse("goaway").toCharArray)

pgpSecretRing := file("./publish/sonatype.asc")

bintrayRepository := "repo"

bintrayPackageLabels := Seq("sbt", "plugin", "scala")

publishMavenStyle := false

publishArtifact in Test := false

homepage := Some(url("https://github.com/timt/naive-http"))

licenses +=("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

pomExtra :=
  <scm>
    <url>git@github.com:timt/naive-http.git</url>
    <connection>scm:git:git@github.com:timt/naive-http.git</connection>
  </scm>
    <developers>
      <developer>
        <id>timt</id>
      </developer>
    </developers>