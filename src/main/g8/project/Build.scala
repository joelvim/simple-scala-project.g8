import sbt._
import Keys._

object BuildSettings {
  val buildOrganization = "$organization$"
  val buildName = "$name$"
  val buildVersion = "$version$"
  val buildScalaVersion = "2.10.0"

  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := buildOrganization,
    version := buildVersion,
    scalaVersion := buildScalaVersion)
}

object Dependencies {
  val specs2 = "org.specs2" % "specs2_2.10" % "1.14" % "test"
}

object Repositories {
  val typesafeRepo = "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
  val sonatypeSnapshots = "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"
  val sonatypeReleases = "releases" at "http://oss.sonatype.org/content/repositories/releases"
}

object ProjectBuild extends Build {
  import Repositories._
  import Dependencies._
  import BuildSettings._

  lazy val project = Project(buildName,
    file("."),
    settings = buildSettings ++ Seq(resolvers := Seq(typesafeRepo, sonatypeReleases, sonatypeSnapshots), libraryDependencies ++= Seq(specs2)))
}
