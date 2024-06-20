import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "com.vladsch.flexmark" % "flexmark-all"   % "0.62.2" % Test,
    "org.scalatest"       %% "scalatest"      % "3.2.17" % Test,
    "org.slf4j"            % "slf4j-simple"   % "1.7.36" % Test,
    "uk.gov.hmrc"         %% "ui-test-runner" % "0.29.0" % Test,
    "org.scalacheck"      %% "scalacheck"     % "1.17.0" % Test,

  )

}
