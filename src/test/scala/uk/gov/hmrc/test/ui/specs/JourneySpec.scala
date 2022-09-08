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
import uk.gov.hmrc.test.ui.pages.income.ApplicantOrPartnerBenefitsPage
import uk.gov.hmrc.test.ui.specs.tags.ZapTests

class JourneySpec extends BaseSpec {

  Feature("Journeys for completing the form and generating a PDF") {

    Scenario(
      """Single parent journey,
        |earning over £50kpa,
        |who does not currently receive CHB""".stripMargin,
      ZapTests
    ) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I complete the journey")
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      LivedOrWorkedOutsideUkPage.answerNo()
      AnyChildLivedWithOthersPage.answerNo()
      ApplicantNamePage.answer()
      RelationshipStatusPage.answerSingle()

      income.ApplicantIncomePage.answer()
      income.ApplicantBenefitsPage.answer()
      income.TaxChargeExplanationPage.continue()

      payments.CurrentlyReceivingChildBenefitPage.answerNo()
      payments.WantToBePaidPage.answerYes()
      payments.PaymentFrequencyPage.answerEveryFourWeeks()
      payments.ApplicantHasSuitableAccountPage.answerYes()
      payments.BankAccountDetailsPage.answer()

      applicant.ApplicantHasPreviousFamilyNamePage.answerYes()
      applicant.ApplicantPreviousFamilyNamePage(1).answer()
      applicant.AddApplicantPreviousFamilyName.remove(1)
      applicant.RemoveApplicantPreviousFamilyNamePage(1).answerNo()
      applicant.AddApplicantPreviousFamilyName.answerNo()
      applicant.ApplicantNinoKnownPage.answerYes()
      applicant.ApplicantNinoPage.answer()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantCurrentAddressPage.answer()
      applicant.ApplicantLivedAtCurrentAddressForOneYearPage.answerNo()
      applicant.ApplicantPreviousAddressPage.answer()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.BestTimeToContactPage.answer()
      applicant.ApplicantNationalityPage.answer()
      applicant.ApplicantEmploymentStatusPage.answer()

      child.ChildNamePage(1).answer()
      child.ChildHasPreviousNamePage(1).answerNo()
      child.ChildBiologicalSexPage(1).answer()
      child.ChildDateOfBirthPage(1).answer()
      child.ChildBirthRegistrationCountryPage(1).answerEngland()
      child.BirthCertificateHasSystemNumberPage(1).answerYes()
      child.ChildBirthCertificateSystemNumberPage(1).answer()
      child.ApplicantRelationshipToChildPage(1).answer()
      child.AdoptingThroughLocalAuthorityPage(1).answerNo()
      child.AnyoneClaimedForChildBeforePage(1).answerNo()
      child.CheckChildDetailsPage(1).continue()

      child.AddChildPage.answerYes()
      child.ChildNamePage(2).answer()
      child.ChildHasPreviousNamePage(2).answerYes()
      child.ChildNameChangedByDeedPollPage(2).answerYes()
      child.ChildPreviousNamePage(2, 1).answer()
      child.AddChildPreviousNamePage(2).remove(1)
      child.RemoveChildPreviousNamePage(2, 1).answerNo()
      child.AddChildPreviousNamePage(2).answerNo()
      child.ChildBiologicalSexPage(2).answer()
      child.ChildDateOfBirthPage(2).answer()
      child.ChildBirthRegistrationCountryPage(2).answerScotland()
      child.ScottishBirthCertificateHasNumbersPage(2).answerYes()
      child.ChildScottishBirthCertificateDetailsPage(2).answer()
      child.ApplicantRelationshipToChildPage(2).answerAdopting()
      child.AdoptingThroughLocalAuthorityPage(2).answerYes()
      child.AnyoneClaimedForChildBeforePage(2).answerYes()
      child.PreviousClaimantNamePage(2).answer()
      child.PreviousClaimantAddressPage(2).answer()
      child.CheckChildDetailsPage(2).continue()

      child.AddChildPage.answerYes()
      child.ChildNamePage(3).answer()
      child.ChildHasPreviousNamePage(3).answerNo()
      child.ChildBiologicalSexPage(3).answer()
      child.ChildDateOfBirthPage(3).answer()
      child.ChildBirthRegistrationCountryPage(3).answerOther()
      child.ApplicantRelationshipToChildPage(3).answer()
      child.AdoptingThroughLocalAuthorityPage(3).answerNo()
      child.AnyoneClaimedForChildBeforePage(3).answerNo()
      child.CheckChildDetailsPage(3).continue()

      child.AddChildPage.remove(1)
      child.RemoveChildPage(1).answerNo()
      child.AddChildPage.answerNo()

      CheckYourAnswersPage.onPage()

      Then("I must be able to download the PDF")
      // TODO
    }

    Scenario(
      """Married parent journey
        |who earns over £50kpa,
        |who already receives CHB
        |""".stripMargin,
      ZapTests
    ) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I complete the journey")
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      LivedOrWorkedOutsideUkPage.answerNo()
      AnyChildLivedWithOthersPage.answerNo()
      ApplicantNamePage.answer()
      RelationshipStatusPage.answerMarried()

      income.ApplicantOrPartnerIncomePage.answer()
      income.ApplicantOrPartnerBenefitsPage.answerNoBenefits()
      income.TaxChargeExplanationPage.continue()

      payments.CurrentlyReceivingChildBenefitPage.answerYes()
      payments.EldestChildNamePage.answer()
      payments.EldestChildDateOfBirthPage.answer()
      payments.WantToBePaidToExistingAccountPage.answerYes()

      applicant.ApplicantHasPreviousFamilyNamePage.answerNo()
      applicant.ApplicantNinoKnownPage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantCurrentAddressPage.answer()
      applicant.ApplicantLivedAtCurrentAddressForOneYearPage.answerYes()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.BestTimeToContactPage.answer()
      applicant.ApplicantNationalityPage.answer()
      applicant.ApplicantEmploymentStatusPage.answer()

      partner.PartnerNamePage.answer()
      partner.PartnerNinoKnownPage.answerYes()
      partner.PartnerNinoPage.answer()
      partner.PartnerDateOfBirthPage.answer()
      partner.PartnerNationalityPage.answer()
      partner.PartnerEmploymentStatusPage.answer()
      partner.PartnerIsHmfOrCivilServantPage.answerNo()
      partner.PartnerEntitledToChildBenefitPage.answerNo()
      partner.PartnerWaitingForEntitlementDecisionPage.answerYes()
      partner.PartnerEldestChildName.answer()
      partner.PartnerEldestChildDateOfBirthPage.answer()

      child.ChildNamePage(1).answer()
      child.ChildHasPreviousNamePage(1).answerNo()
      child.ChildBiologicalSexPage(1).answer()
      child.ChildDateOfBirthPage(1).answer()
      child.ChildBirthRegistrationCountryPage(1).answerEngland()
      child.BirthCertificateHasSystemNumberPage(1).answerNo()
      child.ApplicantRelationshipToChildPage(1).answer()
      child.AdoptingThroughLocalAuthorityPage(1).answerNo()
      child.AnyoneClaimedForChildBeforePage(1).answerNo()
      child.CheckChildDetailsPage(1).continue()
      child.AddChildPage.answerNo()

      CheckYourAnswersPage.onPage()

      Then("I must be able to download the PDF")
      // TODO
    }
  }

  Feature("Extra page journeys") {

    Scenario("A person cohabiting with a partner", ZapTests) {

      Given("I am on the 'Relationship type' page")
      StartPage.loadPage()
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      LivedOrWorkedOutsideUkPage.answerNo()
      AnyChildLivedWithOthersPage.answerNo()
      ApplicantNamePage.answer()

      When("I answer that I am cohabiting with a partner")
      RelationshipStatusPage.answerCohabiting()

      Then("I must be shown the 'Cohabiting start date' page")
      CohabitingDatePage.onPage()
    }

    Scenario("A person who is separated", ZapTests) {

      Given("I am on the 'Relationship type' page")
      StartPage.loadPage()
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      LivedOrWorkedOutsideUkPage.answerNo()
      AnyChildLivedWithOthersPage.answerNo()
      ApplicantNamePage.answer()

      When("I answer that I am separated")
      RelationshipStatusPage.answerSeparated()

      Then("I must be shown the 'Separation date' page")
      SeparationDatePage.onPage()
    }

    Scenario("A person who is HM Forces or a civil servant abroad", ZapTests) {

      Given("I answer that I have lived outside the UK in the last 3 months")
      StartPage.loadPage()
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      LivedOrWorkedOutsideUkPage.answerYes()

      When("I answer that I am a civil servant")
      applicant.ApplicantIsHmfOrCivilServantPage.answerYes()

      Then("I must continue with the journey")
      AnyChildLivedWithOthersPage.onPage()
    }

    Scenario(
      "A person who initially indicates they want to be paid weekly, but who changes their answers so that they would be ineligible to be paid weekly",
      ZapTests
    ) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I complete the journey")
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      LivedOrWorkedOutsideUkPage.answerNo()
      AnyChildLivedWithOthersPage.answerNo()
      ApplicantNamePage.answer()
      RelationshipStatusPage.answerMarried()

      income.ApplicantOrPartnerIncomePage.answer()
      income.ApplicantOrPartnerBenefitsPage.answerUniversalCredit()
      income.TaxChargeExplanationPage.continue()

      payments.CurrentlyReceivingChildBenefitPage.answerNo()
      payments.WantToBePaidPage.answerYes()
      payments.PaymentFrequencyPage.answerWeekly()
      payments.ApplicantHasSuitableAccountPage.answerYes()
      payments.BankAccountDetailsPage.answer()

      applicant.ApplicantHasPreviousFamilyNamePage.answerNo()
      applicant.ApplicantNinoKnownPage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantCurrentAddressPage.answer()
      applicant.ApplicantLivedAtCurrentAddressForOneYearPage.answerYes()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.BestTimeToContactPage.answer()
      applicant.ApplicantNationalityPage.answer()
      applicant.ApplicantEmploymentStatusPage.answer()

      partner.PartnerNamePage.answer()
      partner.PartnerNinoKnownPage.answerYes()
      partner.PartnerNinoPage.answer()
      partner.PartnerDateOfBirthPage.answer()
      partner.PartnerNationalityPage.answer()
      partner.PartnerEmploymentStatusPage.answer()
      partner.PartnerIsHmfOrCivilServantPage.answerYes()
      partner.PartnerEntitledToChildBenefitPage.answerNo()
      partner.PartnerWaitingForEntitlementDecisionPage.answerYes()
      partner.PartnerEldestChildName.answer()
      partner.PartnerEldestChildDateOfBirthPage.answer()

      child.ChildNamePage(1).answer()
      child.ChildHasPreviousNamePage(1).answerNo()
      child.ChildBiologicalSexPage(1).answer()
      child.ChildDateOfBirthPage(1).answer()
      child.ChildBirthRegistrationCountryPage(1).answerScotland()
      child.ScottishBirthCertificateHasNumbersPage(1).answerNo()
      child.ApplicantRelationshipToChildPage(1).answer()
      child.AdoptingThroughLocalAuthorityPage(1).answerNo()
      child.AnyoneClaimedForChildBeforePage(1).answerNo()
      child.CheckChildDetailsPage(1).continue()
      child.AddChildPage.answerNo()

      Then("I change my answers to indicate do not receive any benefits")
      CheckYourAnswersPage.changeBenefits()
      ApplicantOrPartnerBenefitsPage.uncheckAnswers()
      ApplicantOrPartnerBenefitsPage.answerNoBenefits()

      Then("I must be shown the 'You cannot be paid weekly' page")
      CannotBePaidWeeklyPage.onPage()
    }
  }

  Feature("Kick-out journeys") {

    Scenario("I have recently claimed Child Benefit", ZapTests) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I say that I have recently claimed Child Benefit")
      StartPage.startNow()
      RecentlyClaimedPage.answerYes()

      Then("I must be shown the already claimed page")
      AlreadyClaimedPage.onPage()
    }

    Scenario("Myself or my partner have previously lived or worked outside the UK and are not HM Forces or a civil servant abroad", ZapTests) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I say that me, or my partner have previously lived or worked outside the UK")
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      LivedOrWorkedOutsideUkPage.answerYes()
      applicant.ApplicantIsHmfOrCivilServantPage.answerNo()

      Then("I must be shown the kick-out page")
      UsePrintAndPostFormPage.onPage()
    }

    Scenario(
      "At least one of the children I am applying for has lived with someone else in the last 12 months",
      ZapTests
    ) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I say that one of the children I am applying for has lived with someone else in the last 12 months")
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      LivedOrWorkedOutsideUkPage.answerNo()
      AnyChildLivedWithOthersPage.answerYes()

      Then("I must be shown the kick-out page")
      UsePrintAndPostFormPage.onPage()
    }
  }
}
