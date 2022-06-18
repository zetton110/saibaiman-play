name := """saibaiman-play"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

val scalikejdbcVersion    = "3.5.0"

val jacksonVersion         = "2.13.3"
val jacksonDatabindVersion = "2.13.3"

val jacksonOverrides = Seq(
  "com.fasterxml.jackson.core"     % "jackson-core",
  "com.fasterxml.jackson.core"     % "jackson-annotations",
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jdk8",
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310"
).map(_ % jacksonVersion)

val jacksonDatabindOverrides = Seq(
  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonDatabindVersion
)
val akkaSerializationJacksonOverrides = Seq(
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-cbor",
  "com.fasterxml.jackson.module"     % "jackson-module-parameter-names",
  "com.fasterxml.jackson.module"    %% "jackson-module-scala"
).map(_ % jacksonVersion)

libraryDependencies ++= Seq(
  guice,
  evolutions,
  ws,
  "org.scalikejdbc" %% "scalikejdbc" % scalikejdbcVersion excludeAll (
    ExclusionRule(
      organization = "org.apache.commons",
      name = "commons-dbcp2"
    )),
  "org.scalikejdbc"       %% "scalikejdbc-syntax-support-macro" % scalikejdbcVersion,
  "org.scalikejdbc"       %% "scalikejdbc-config"               % scalikejdbcVersion,
  "org.scalikejdbc"       %% "scalikejdbc-play-dbapi-adapter"   % "2.8.0-scalikejdbc-3.5",
  "org.postgresql"         % "postgresql"                       % "42.4.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  "io.monix"                     %% "monix"                         % "3.4.1",
  "com.fasterxml.jackson.module" %% "jackson-module-scala"          % "2.13.3"
) ++ jacksonDatabindOverrides ++ jacksonOverrides ++ akkaSerializationJacksonOverrides
