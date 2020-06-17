import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "dublin-forecast",
    libraryDependencies += scalaTest % Test
  )

libraryDependencies ++= Seq(
    "com.lihaoyi" %% "requests" % "0.5.1",
    "org.scala-lang.modules" % "scala-xml_2.12" % "1.0.6"
)

