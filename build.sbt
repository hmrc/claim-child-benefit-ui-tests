lazy val testSuite = (project in file("."))
  .disablePlugins(JUnitXmlReportPlugin) // Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(
    name := "claim-child-benefit-ui-tests",
    version := "0.1.0",
    scalaVersion := "2.13.8",
    scalacOptions ++= Seq("-feature"),
    libraryDependencies ++= Dependencies.test,
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.15.4" % Test,
    javacOptions ++= Seq("-source", "11", "-target", "11"),
    libraryDependencies += "org.json4s" %% "json4s-native" % "4.0.3",
    libraryDependencies += "org.json4s" %% "json4s-ext" % "4.0.3",
    Test / testOptions := Seq.empty
  )
