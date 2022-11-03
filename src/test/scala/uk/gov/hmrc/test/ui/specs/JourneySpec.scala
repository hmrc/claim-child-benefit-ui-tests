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
import uk.gov.hmrc.test.ui.pages.applicant.ApplicantPhoneNumberPage
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
      ApplicantNamePage.answer()
      RelationshipStatusPage.answerSingle()
      AlwaysLivedInUkPage.answerYes()

      income.ApplicantIncomePage.answer()
      income.ApplicantBenefitsPage.answer()

      payments.CurrentlyReceivingChildBenefitPage.answerNotClaiming()
      payments.WantToBePaidPage.answerYes()
      payments.PaymentFrequencyPage.answerEveryFourWeeks()
      payments.ApplicantHasSuitableAccountPage.answerYes()
      payments.BankAccountHolderPage.answerApplicant()
      payments.BankAccountDetailsPage.answer()

      applicant.ApplicantHasPreviousFamilyNamePage.answerYes()
      applicant.ApplicantPreviousFamilyNamePage(1).answer()
      applicant.AddApplicantPreviousFamilyName.remove(1)
      applicant.RemoveApplicantPreviousFamilyNamePage(1).answerNo()
      applicant.AddApplicantPreviousFamilyName.answerNo()
      applicant.ApplicantNinoKnownPage.answerYes()
      applicant.ApplicantNinoPage.answer()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantCurrentUkAddressPage.answer()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.ApplicantNationalityPage.answerBritish()

      child.ChildNamePage(1).answer()
      child.ChildHasPreviousNamePage(1).answerNo()
      child.ChildBiologicalSexPage(1).answer()
      child.ChildDateOfBirthPage(1).answer()
      child.ChildBirthRegistrationCountryPage(1).answerEngland()
      child.BirthCertificateHasSystemNumberPage(1).answerYes()
      child.ChildBirthCertificateSystemNumberPage(1).answer()
      child.AdoptingThroughLocalAuthorityPage(1).answerNo()
      child.ApplicantRelationshipToChildPage(1).answer()
      child.AnyoneClaimedForChildBeforePage(1).answerNo()
      child.ChildLivesWithApplicantPage(1).answerNo()
      child.GuardianNamePage(1).answer()
      child.GuardianAddressInUkPage(1).answerYes()
      child.GuardianUkAddressPage(1).answer()
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
      child.AdoptingThroughLocalAuthorityPage(2).answerYes()
      child.ApplicantRelationshipToChildPage(2).answerAdopting()
      child.AnyoneClaimedForChildBeforePage(2).answerYes()
      child.PreviousClaimantNamePage(2).answer()
      child.PreviousClaimantAddressInUkPage(2).answerYes()
      child.PreviousClaimantUkAddressPage(2).answer()
      child.ChildLivesWithApplicantPage(2).answerNo()
      child.GuardianNamePage(2).answer()
      child.GuardianAddressInUkPage(2).answerNo()
      child.GuardianInternationalAddressPage(2).answer()
      child.CheckChildDetailsPage(2).continue()

      child.AddChildPage.answerYes()
      child.ChildNamePage(3).answer()
      child.ChildHasPreviousNamePage(3).answerNo()
      child.ChildBiologicalSexPage(3).answer()
      child.ChildDateOfBirthPage(3).answer()
      child.ChildBirthRegistrationCountryPage(3).answerOther()
      child.AdoptingThroughLocalAuthorityPage(3).answerNo()
      child.ApplicantRelationshipToChildPage(3).answer()
      child.AnyoneClaimedForChildBeforePage(3).answerYes()
      child.PreviousClaimantNamePage(3).answer()
      child.PreviousClaimantAddressInUkPage(3).answerNo()
      child.PreviousClaimantInternationalAddressPage(3).answer()
      child.ChildLivesWithApplicantPage(3).answerYes()
      child.ChildLivedWithAnyoneElsePage(3).answerNo()
      child.CheckChildDetailsPage(3).continue()

      child.AddChildPage.remove(1)
      child.RemoveChildPage(1).answerNo()
      child.AddChildPage.answerNo()

      AdditionalInformationPage.answerWithInformation()
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
      ApplicantNamePage.answer()
      RelationshipStatusPage.answerMarried()
      AlwaysLivedInUkPage.answerYes()

      income.ApplicantOrPartnerIncomePage.answer()
      income.ApplicantOrPartnerBenefitsPage.answerNoBenefits()

      payments.CurrentlyReceivingChildBenefitPage.answerGettingPayments()
      payments.EldestChildNamePage.answer()
      payments.EldestChildDateOfBirthPage.answer()
      payments.WantToBePaidPage.answerYes()
      payments.WantToBePaidToExistingAccountPage.answerYes()

      applicant.ApplicantHasPreviousFamilyNamePage.answerNo()
      applicant.ApplicantNinoKnownPage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantCurrentUkAddressPage.answer()
      applicant.ApplicantLivedAtCurrentAddressForOneYearPage.answerNo()
      applicant.ApplicantPreviousUkAddressPage.answer()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.ApplicantNationalityPage.answerDualWithBritish()

      partner.PartnerNamePage.answer()
      partner.PartnerNinoKnownPage.answerYes()
      partner.PartnerNinoPage.answer()
      partner.PartnerDateOfBirthPage.answer()
      partner.PartnerNationalityPage.answer()
      partner.PartnerClaimingChildBenefitPage.answerGettingPayments()
      partner.PartnerEldestChildName.answer()
      partner.PartnerEldestChildDateOfBirthPage.answer()

      child.ChildNamePage(1).answer()
      child.ChildHasPreviousNamePage(1).answerNo()
      child.ChildBiologicalSexPage(1).answer()
      child.ChildDateOfBirthPage(1).answer()
      child.ChildBirthRegistrationCountryPage(1).answerEngland()
      child.BirthCertificateHasSystemNumberPage(1).answerNo()
      child.AdoptingThroughLocalAuthorityPage(1).answerNo()
      child.ApplicantRelationshipToChildPage(1).answer()
      child.AnyoneClaimedForChildBeforePage(1).answerNo()
      child.ChildLivesWithApplicantPage(1).answerYes()
      child.ChildLivedWithAnyoneElsePage(1).answerYes()
      child.PreviousGuardianNamePage(1).answer()
      child.PreviousGuardianAddressInUkPage(1).answerYes()
      child.PreviousGuardianUkAddressPage(1).answer()
      child.PreviousGuardianPhoneNumberPage(1).answer()
      child.DateChildStartedLivingWithApplicantPage(1).answer()
      child.CheckChildDetailsPage(1).continue()
      child.AddChildPage.answerYes()

      child.ChildNamePage(2).answer()
      child.ChildHasPreviousNamePage(2).answerNo()
      child.ChildBiologicalSexPage(2).answer()
      child.ChildDateOfBirthPage(2).answer()
      child.ChildBirthRegistrationCountryPage(2).answerEngland()
      child.BirthCertificateHasSystemNumberPage(2).answerNo()
      child.AdoptingThroughLocalAuthorityPage(2).answerNo()
      child.ApplicantRelationshipToChildPage(2).answer()
      child.AnyoneClaimedForChildBeforePage(2).answerNo()
      child.ChildLivesWithApplicantPage(2).answerYes()
      child.ChildLivedWithAnyoneElsePage(2).answerYes()
      child.PreviousGuardianNamePage(2).answer()
      child.PreviousGuardianAddressInUkPage(2).answerNo()
      child.PreviousGuardianInternationalAddressPage(2).answer()
      child.PreviousGuardianPhoneNumberPage(2).answer()
      child.DateChildStartedLivingWithApplicantPage(2).answer()
      child.CheckChildDetailsPage(2).continue()
      child.AddChildPage.answerNo()

      AdditionalInformationPage.answerWithNoInformation()
      CheckYourAnswersPage.onPage()

      Then("I must be able to download the PDF")
      // TODO
    }
  }

  Feature("Extra page journeys") {

    Scenario("A person with an international previous address", ZapTests) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I complete the journey")
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      ApplicantNamePage.answer()
      RelationshipStatusPage.answerMarried()
      AlwaysLivedInUkPage.answerNo()
      applicant.ApplicantIsHmfOrCivilServantPage.answerYes()

      income.ApplicantOrPartnerIncomePage.answer()
      income.ApplicantOrPartnerBenefitsPage.answerNoBenefits()

      payments.CurrentlyReceivingChildBenefitPage.answerGettingPayments()
      payments.EldestChildNamePage.answer()
      payments.EldestChildDateOfBirthPage.answer()
      payments.WantToBePaidPage.answerYes()
      payments.WantToBePaidToExistingAccountPage.answerYes()

      applicant.ApplicantHasPreviousFamilyNamePage.answerNo()
      applicant.ApplicantNinoKnownPage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantCurrentAddressInUkPage.answerYes()
      applicant.ApplicantCurrentUkAddressPage.answer()
      applicant.ApplicantLivedAtCurrentAddressForOneYearPage.answerNo()

      When("I answer that I have an international previous address")
      applicant.ApplicantPreviousAddressInUkPage.answerNo()
      applicant.ApplicantPreviousInternationalAddressPage.answer()

      Then("I must be able to continue the journey")
      ApplicantPhoneNumberPage.onPage()
    }

    Scenario("A person cohabiting with a partner", ZapTests) {

      Given("I am on the 'Relationship type' page")
      StartPage.loadPage()
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
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
      ApplicantNamePage.answer()

      When("I answer that I am separated")
      RelationshipStatusPage.answerSeparated()

      Then("I must be shown the 'Separation date' page")
      SeparationDatePage.onPage()
    }

    Scenario("A person who is HM Forces or a civil servant abroad", ZapTests) {

      Given("I answer that I have not always lived in the UK")
      StartPage.loadPage()
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      ApplicantNamePage.answer()
      RelationshipStatusPage.answerSingle()
      AlwaysLivedInUkPage.answerNo()

      When("I answer that I am a civil servant")
      applicant.ApplicantIsHmfOrCivilServantPage.answerYes()

      And("I continue with the journey")
      income.ApplicantIncomePage.answer()
      income.ApplicantBenefitsPage.answer()

      payments.CurrentlyReceivingChildBenefitPage.answerNotClaiming()
      payments.WantToBePaidPage.answerNo()

      applicant.ApplicantHasPreviousFamilyNamePage.answerNo()
      applicant.ApplicantNinoKnownPage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()

      Then("I must be asked if my current address is in the UK")
      applicant.ApplicantCurrentAddressInUkPage.onPage()
    }

    Scenario("A person whose partner is HM Forces or a civil servant abroad", ZapTests) {

      Given("I answer that I have not always lived in the UK")
      StartPage.loadPage()
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      ApplicantNamePage.answer()
      RelationshipStatusPage.answerMarried()
      AlwaysLivedInUkPage.answerNo()

      When("I answer that I am not a civil servant")
      applicant.ApplicantIsHmfOrCivilServantPage.answerNo()

      And("I answer that my partner is HM Forces or a civil servant abroad")
      partner.PartnerIsHmfOrCivilServantPage.answerYes()

      And("I continue with the journey")
      income.ApplicantOrPartnerIncomePage.answer()
      income.ApplicantOrPartnerBenefitsPage.answerNoBenefits()

      payments.CurrentlyReceivingChildBenefitPage.answerNotClaiming()
      payments.WantToBePaidPage.answerNo()

      applicant.ApplicantHasPreviousFamilyNamePage.answerNo()
      applicant.ApplicantNinoKnownPage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()

      Then("I must be asked if my current address is in the UK")
      applicant.ApplicantCurrentAddressInUkPage.onPage()
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
      ApplicantNamePage.answer()
      RelationshipStatusPage.answerMarried()
      AlwaysLivedInUkPage.answerYes()

      income.ApplicantOrPartnerIncomePage.answer()
      income.ApplicantOrPartnerBenefitsPage.answerUniversalCredit()

      payments.CurrentlyReceivingChildBenefitPage.answerNotClaiming()
      payments.WantToBePaidPage.answerYes()
      payments.PaymentFrequencyPage.answerWeekly()
      payments.ApplicantHasSuitableAccountPage.answerYes()
      payments.BankAccountHolderPage.answerJoint()
      payments.BankAccountDetailsPage.answer()

      applicant.ApplicantHasPreviousFamilyNamePage.answerNo()
      applicant.ApplicantNinoKnownPage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantCurrentUkAddressPage.answer()
      applicant.ApplicantLivedAtCurrentAddressForOneYearPage.answerYes()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.ApplicantNationalityPage.answerBritish()

      partner.PartnerNamePage.answer()
      partner.PartnerNinoKnownPage.answerYes()
      partner.PartnerNinoPage.answer()
      partner.PartnerDateOfBirthPage.answer()
      partner.PartnerNationalityPage.answer()
      partner.PartnerClaimingChildBenefitPage.answerGettingPayments()
      partner.PartnerEldestChildName.answer()
      partner.PartnerEldestChildDateOfBirthPage.answer()

      child.ChildNamePage(1).answer()
      child.ChildHasPreviousNamePage(1).answerNo()
      child.ChildBiologicalSexPage(1).answer()
      child.ChildDateOfBirthPage(1).answer()
      child.ChildBirthRegistrationCountryPage(1).answerScotland()
      child.ScottishBirthCertificateHasNumbersPage(1).answerNo()
      child.AdoptingThroughLocalAuthorityPage(1).answerNo()
      child.ApplicantRelationshipToChildPage(1).answer()
      child.AnyoneClaimedForChildBeforePage(1).answerNo()
      child.ChildLivesWithApplicantPage(1).answerYes()
      child.ChildLivedWithAnyoneElsePage(1).answerNo()
      child.CheckChildDetailsPage(1).continue()
      child.AddChildPage.answerNo()

      AdditionalInformationPage.answerWithInformation()

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

    Scenario(
      "I have previously lived or worked outside the UK and am not HM Forces or a civil servant abroad",
      ZapTests
    ) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I say that I have not always lived in the UK")
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      ApplicantNamePage.answer()
      RelationshipStatusPage.answerSingle()
      AlwaysLivedInUkPage.answerNo()
      applicant.ApplicantIsHmfOrCivilServantPage.answerNo()

      Then("I must be shown the kick-out page")
      UsePrintAndPostFormPage.onPage()
    }

    Scenario(
      "I have not always lived in the UK and neither me nor my partner are HM Forces or a civil servant abroad",
      ZapTests
    ) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I say that I have previously lived or worked outside the UK")
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      ApplicantNamePage.answer()
      RelationshipStatusPage.answerMarried()
      AlwaysLivedInUkPage.answerNo()
      applicant.ApplicantIsHmfOrCivilServantPage.answerNo()
      partner.PartnerIsHmfOrCivilServantPage.answerNo()

      Then("I must be shown the kick-out page")
      UsePrintAndPostFormPage.onPage()
    }

    Scenario(
      "I am not British",
      ZapTests
    ) {

      Given("I am on the start page")
      StartPage.loadPage()

      When("I say that I am not British")
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()
      ApplicantNamePage.answer()
      RelationshipStatusPage.answerSingle()
      AlwaysLivedInUkPage.answerYes()

      income.ApplicantIncomePage.answer()
      income.ApplicantBenefitsPage.answer()

      payments.CurrentlyReceivingChildBenefitPage.answerNotClaiming()
      payments.WantToBePaidPage.answerYes()
      payments.PaymentFrequencyPage.answerEveryFourWeeks()
      payments.ApplicantHasSuitableAccountPage.answerYes()
      payments.BankAccountHolderPage.answerApplicant()
      payments.BankAccountDetailsPage.answer()

      applicant.ApplicantHasPreviousFamilyNamePage.answerYes()
      applicant.ApplicantPreviousFamilyNamePage(1).answer()
      applicant.AddApplicantPreviousFamilyName.remove(1)
      applicant.RemoveApplicantPreviousFamilyNamePage(1).answerNo()
      applicant.AddApplicantPreviousFamilyName.answerNo()
      applicant.ApplicantNinoKnownPage.answerYes()
      applicant.ApplicantNinoPage.answer()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantCurrentUkAddressPage.answer()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.ApplicantNationalityPage.answerOther()

      Then("I must be shown the kick-out page")
      CannotUseServiceNationalityPage.onPage()
    }
  }
}
