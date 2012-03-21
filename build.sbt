name := "wicket-scala2"

organization := "de.duesenklipper"

version := "0.1-SNAPSHOT"

libraryDependencies ++= Seq(
              "org.specs2" %% "specs2" % "1.7.1" % "test",
              "org.scala-tools.testing" %% "scalacheck" % "1.9" % "test",
              "junit" % "junit" % "4.8" % "test",
              "org.apache.wicket" % "wicket-core" % "1.5.5",
              "org.mortbay.jetty" % "jetty" % "6.1.4" % "test",
              "org.mortbay.jetty" % "jetty-util" % "6.1.4" % "test",
              "org.mortbay.jetty" % "jetty-management" % "6.1.4" % "test",
              "org.slf4j" % "slf4j-api" % "1.6.1",
              "org.slf4j" % "slf4j-log4j12" % "1.6.1",
              "org.wicketstuff.scala" % "wicketstuff-scala" % "1.5.5"
            )



