sbt-dist-zip  [![Build Status](https://travis-ci.org/timt/sbt-dist-zip.png?branch=master)](https://travis-ci.org/timt/sbt-dist-zip) [ ![Download](https://api.bintray.com/packages/timt/repo/sbt-dist-zip/images/download.png) ](https://bintray.com/timt/repo/sbt-dist-zip/_latestVersion)
===========================================================================================================================================================================================================================================================================================
A really simple sbt plugin that creates a distributable zip file containing the main project artifact and any files that are in src/main/dist

Requirements
------------

* [sbt](http://www.scala-sbt.org/0.13/docs/index.html)  0.13.6+

Installation
------------

Add the following lines to your projects.sbt

    //autoplugin
    addSbtPlugin("io.shaka" % "sbt-dist-zip" % "10")

Usage

    sbt distZip
    
This will create the file target/[projectName].zip containing the main project artifact and and files in src/main/dist

Setting to specify an alternative src folder for scripts
    distZipScripts := "main/scripts"

Setting to specify an alternative artifact file (task dependency)
    distZipArtifactFile := sbtassembly.AssemblyKeys.assembly.value

Code license
------------
Apache License 2.0