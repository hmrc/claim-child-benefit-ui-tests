import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"         %% "webdriver-factory" % "0.46.0"   % Test,
    "org.scalatest"       %% "scalatest"         % "3.2.17"   % Test,
    "org.scalacheck"      %% "scalacheck"        % "1.17.0"   % Test,
    "org.scalatestplus"   %% "selenium-4-12"     % "3.2.17.0" % Test,
    "com.vladsch.flexmark" % "flexmark-all"      % "0.62.2"   % Test,
    "org.pegdown"          % "pegdown"           % "1.6.0"    % Test,
    "com.typesafe"         % "config"            % "1.4.2"    % Test
  )
}
