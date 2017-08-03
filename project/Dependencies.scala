import sbt._

object Dependencies {
  lazy val akkaHttpVersion = "10.0.6" 

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1"
  lazy val akkaHttp = "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
  lazy val akkaHttpTestKit = "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion
  lazy val akkaJson = "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion

  lazy val akkaKafka = "com.typesafe.akka" %% "akka-stream-kafka" % "0.16"
  lazy val slf4j = "org.slf4j" % "slf4j-simple" % "1.7.25"
  lazy val scalaMock = "org.scalamock" %% "scalamock-scalatest-support" % "3.5.0"
}
