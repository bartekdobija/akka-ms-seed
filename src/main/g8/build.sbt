enablePlugins(JavaAppPackaging)

enablePlugins(AshScriptPlugin)

lazy val commonSettings = Seq(
  version := "0.1",
  organization := "com.github.bartekdobija",
  scalaVersion := "2.12.3"
)

lazy val scalaTestVersion = "3.0.1"
lazy val akkaHttpVersion = "10.0.10"
lazy val gatlingVersion = "2.3.0"

// Docker configuration
lazy val baseImage = "openjdk:8-alpine"
lazy val dockerPort = 8080

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    name := "$name$",
    dockerExposedPorts := Seq(dockerPort),
    dockerBaseImage := baseImage,
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % scalaTestVersion % Test,
      // akka http used as the client facing API gateway
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test
      //"io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion % Test
    )
  )

fork in Test := true
