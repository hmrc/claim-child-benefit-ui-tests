lazy val testSuite = (project in file("."))
  .disablePlugins(JUnitXmlReportPlugin) //Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(
    name := "claim-child-benefit-ui-tests",
    version := "0.1.0",
    scalaVersion := "2.13.10",
    scalacOptions ++= Seq("-feature", "-deprecation", "-Xfatal-warnings"),
    libraryDependencies ++= Dependencies.test
  )
