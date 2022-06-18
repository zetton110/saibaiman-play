name := """saibaiman-play"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

val scalikejdbcVersion    = "3.5.0"

libraryDependencies ++= Seq(
  guice,
  evolutions,
  ws,
  "org.scalikejdbc" %% "scalikejdbc" % scalikejdbcVersion excludeAll (
    ExclusionRule(
      organization = "org.apache.commons",
      name = "commons-dbcp2"
    )
    ),
  "org.scalikejdbc"       %% "scalikejdbc-syntax-support-macro" % scalikejdbcVersion,
  "org.scalikejdbc"       %% "scalikejdbc-config"               % scalikejdbcVersion,
  "org.scalikejdbc"       %% "scalikejdbc-play-dbapi-adapter"   % "2.8.0-scalikejdbc-3.5",
  "org.postgresql"         % "postgresql"                       % "42.4.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
)
