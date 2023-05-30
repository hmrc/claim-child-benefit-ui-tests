import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"         %% "webdriver-factory" % "0.43.0"         % Test,
    "org.jsoup"            % "jsoup"             % "1.14.3"         % Test,
    "uk.gov.hmrc"         %% "auth-client"       % "5.12.0-play-28" % Test,
    "com.typesafe.play"   %% "play-json"         % "2.9.1"          % Test,
    "commons-codec"        % "commons-codec"     % "1.15"           % Test,
    "org.scalaj"          %% "scalaj-http"       % "2.4.2"          % Test,
    "org.scalatest"       %% "scalatest"         % "3.2.15"         % Test,
    "org.scalatestplus"   %% "selenium-3-141"    % "3.2.0.0"        % Test,
    "com.vladsch.flexmark" % "flexmark-all"      % "0.35.10"        % Test,
    "io.cucumber"         %% "cucumber-scala"    % "6.9.1"          % Test,
    "io.cucumber"          % "cucumber-junit"    % "6.9.1"          % Test,
    "junit"                % "junit"             % "4.12"           % Test,
    "com.novocode"         % "junit-interface"   % "0.11"           % Test,
    "com.typesafe"         % "config"            % "1.3.2"          % Test,
    "org.seleniumhq.selenium" % "selenium-java"  % "3.141.59"       % Test
  )

}
