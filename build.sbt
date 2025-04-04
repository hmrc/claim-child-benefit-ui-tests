lazy val testSuite = (project in file("."))
  .disablePlugins(JUnitXmlReportPlugin) //Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(
    name := "claim-child-benefit-ui-tests",
    version := "0.1.0",
    scalaVersion := "3.6.4",
    scalacOptions ++= Seq(
      "-feature",
      "-Xfatal-warnings"
    ),
    libraryDependencies ++= Dependencies.test
  )
