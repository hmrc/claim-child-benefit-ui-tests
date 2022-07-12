/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.pages.{AnyChildLivedWithOthersPage, LivedOrWorkedOutsideUkPage, StartPage, UsePrintAndPostFormPage}
import uk.gov.hmrc.test.ui.specs.tags.ZapTests

class JourneySpec extends BaseSpec {

  Feature("Journeys for completing the form and generating a PDF") {

    // TODO stand in for a specific journey
    ignore("Simple journey", ZapTests) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I complete the X journey")
      StartPage.startNow()
      LivedOrWorkedOutsideUkPage.answerNo()
      AnyChildLivedWithOthersPage.answerNo()

      Then("I should be able to download the PDF")
    }
  }

  Feature("Kick-out journeys") {

    Scenario("Myself or my partner have previously lived or worked outside the UK", ZapTests) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I say that me, or my partner have previously lived or worked outside the UK")
      StartPage.startNow()
      LivedOrWorkedOutsideUkPage.answerYes()

      Then("I should be shown the kick-out page")
      UsePrintAndPostFormPage.onPage()
    }

    Scenario(
      "At least one of the children I am applying for has lived with someone else in the last 12 months",
      ZapTests
    ) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I say that me and my partner have never lived or worked outside the UK")
      StartPage.startNow()
      LivedOrWorkedOutsideUkPage.answerNo()

      And("I say that one of the children I am applying for has lived with someone else in the last 12 months")
      AnyChildLivedWithOthersPage.answerYes()

      Then("I should be shown the kick-out page")
      UsePrintAndPostFormPage.onPage()
    }
  }
}
