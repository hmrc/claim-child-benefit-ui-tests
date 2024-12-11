import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "com.vladsch.flexmark" % "flexmark-all"   % "0.64.8" % Test,
    "org.scalatest"       %% "scalatest"      % "3.2.19" % Test,
    "org.slf4j"            % "slf4j-simple"   % "2.0.16" % Test,
    "uk.gov.hmrc"         %% "ui-test-runner" % "0.43.0" % Test,
    "org.scalacheck"      %% "scalacheck"     % "1.18.0" % Test,

  )

}
