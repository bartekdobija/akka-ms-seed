import sbt._

object Dependencies {

  lazy val scalaTestVersion = "3.0.1"
  lazy val akkaHttpVersion = "10.0.10"
  lazy val scalajHttpVersion = "2.3.0"
  lazy val dropwizardVersion  = "1.2.0"
  lazy val kafkaVersion = "0.11.0.1"

  val akkaService = Seq(
    "org.scalatest" %% "scalatest" % scalaTestVersion % Test,

    "org.apache.kafka" % "kafka-clients" % kafkaVersion,

    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test
  )

}
