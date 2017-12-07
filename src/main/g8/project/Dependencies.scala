import sbt._

object Dependencies {

  lazy val scalaTestVersion = "3.0.1"
  lazy val akkaHttpVersion = "10.0.10"
  lazy val kafkaVersion = "0.11.0.1"
  lazy val embeddedKafkaVersion = "1.0.0"

  val akkaService = Seq(
    "org.scalatest" %% "scalatest" % scalaTestVersion % Test,
    "net.manub" %% "scalatest-embedded-kafka" % embeddedKafkaVersion % Test,

    "org.apache.kafka" % "kafka-clients" % kafkaVersion,

    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test
  )

}
