name := """yard-sale-helper"""

version := "1.0"

scalaVersion := "2.11.7"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean, SbtWeb)

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "mysql" % "mysql-connector-java" % "5.1.36"
)