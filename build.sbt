import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.yoppworks",
      scalaVersion := "2.11.11",
      version      := "0.1.0"
    )),
    name := "AsyncChat",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      akkaHttp,
      akkaJson,
      akkaHttpTestKit % Test,
      akkaKafka,
      slf4j,
      scalaMock % Test
    )
  )
