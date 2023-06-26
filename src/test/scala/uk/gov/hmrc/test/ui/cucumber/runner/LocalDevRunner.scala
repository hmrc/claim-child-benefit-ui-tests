/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.cucumber.runner

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith

/**
  * This runner allow to run all test with "@local-dev" annotation, including debug in IntelliJ.
  * How to setup :
  *   Run first time from IntelliJ
  *   Then edit runner configuration and add this environmental variables:
  *   -ea
  *   -Dbrowser=chrome
  *   -Denvironment=local
  *   -Dwebdriver.chrome.driver=path to chrome drive, only if you want to run with chrome
  *   -Dwebdriver.gecko.driver=path to gecko driver, only if you want to run with firefox
  *
  *   For MS Windows with WSL you need to add additional parameter:
  *   -Djava.net.preferIPv6Addresses=true
  */
@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features"),
  glue = Array("uk.gov.hmrc.test.ui.cucumber.stepdefs"),
  plugin = Array("pretty", "html:target/cucumber", "json:target/cucumber.json", "junit:target/test-reports/Runner.xml"),
  tags = "@local-dev"
)
class LocalDevRunner {}
