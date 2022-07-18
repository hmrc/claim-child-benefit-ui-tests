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

import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.specs.tags.ZapTests

class JourneySpec extends BaseSpec {

  Feature("Journeys for completing the form and generating a PDF") {

    Scenario("Simple journey", ZapTests) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I complete the simplest journey")
      StartPage.startNow()
      LivedOrWorkedOutsideUkPage.answerNo()
      AnyChildLivedWithOthersPage.answerNo()
      ApplicantNamePage.answer()
      RelationshipStatusPage.answerSingle()

      income.ApplicantIncomeOver50kPage.answerNo()
      income.ApplicantBenefitsPage.answer()
      income.TaxChargeExplanationPage.continue()

      payments.ClaimedChildBenefitBeforePage.answerNo()
      payments.WantToBePaidPage.answerNo()

      applicant.ApplicantHasPreviousFamilyNamePage.answerNo()
      applicant.ApplicantNinoKnownPage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantCurrentAddressPage.answer()
      applicant.ApplicantLivedAtCurrentAddressForOneYearPage.answerYes()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.BestTimeToContactPage.answer()
      applicant.ApplicantNationalityPage.answer()
      applicant.ApplicantEmploymentStatusPage.answer()

      child.ChildNamePage(1).answer()
      child.ChildHasPreviousNamePage(1).answerNo()
      child.ChildBiologicalSexPage(1).answer()
      child.ChildDateOfBirthPage(1).answer()
      child.ChildBirthRegistrationCountryPage(1).answer()
      child.ChildBirthCertificateSystemNumberPage(1).answer()
      child.ApplicantRelationshipToChildPage(1).answer()
      child.AnyoneClaimedForChildBeforePage(1).answerNo()
      child.CheckChildDetailsPage(1).continue()
      child.AddChildPage.answerNo()

      CheckYourAnswersPage.onPage()

      Then("I should be able to download the PDF")
      // TODO
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
