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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.StartUpTearDown
import uk.gov.hmrc.test.ui.pages.{RecentlyClaimedPage, SignInPage, StartPage, TaskListPage, applicant, partner}
import uk.gov.hmrc.webdriver.SingletonDriver

import scala.util.Try

trait BaseDetailsSteps extends ScalaDsl with EN with StartUpTearDown with Eventually with Matchers {

  sys.addShutdownHook {
    Try(SingletonDriver.closeInstance)
  }
  Given("""^I am on the start page$""") { () =>
    StartPage.loadPage();
    StartPage.startNow()
    RecentlyClaimedPage.answerNo()
    SignInPage.answerNo()
  }

  Then("""^Enter Applicant NI Number$""") { () =>
    TaskListPage.startApplicantSection()
    applicant.ApplicantNinoKnownPage.answerYes()
    applicant.ApplicantNinoPage.enterNiNo()
  }

  Then("""^I navigate to the Relationship details and selected relationship$""") { () =>
    TaskListPage.startPartnerDetails()
    partner.RelationshipStatusPage.answerSingle()
    partner.CheckPartnerDetailsPage.answer()
  }
}
