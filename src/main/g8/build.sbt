enablePlugins(JavaAppPackaging)
enablePlugins(AshScriptPlugin)

import Dependencies._

lazy val commonSettings = Seq(
  version := "0.1",
  organization := "com.github.bartekdobija",
  scalaVersion := "2.12.3"
)

// Docker configuration
lazy val baseImage = "openjdk:8-alpine"
lazy val dockerPort = 8080

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    name := "$name$",
    dockerExposedPorts := Seq(dockerPort),
    dockerBaseImage := baseImage,
    libraryDependencies ++= akkaService
  )

fork in Test := true
