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

package uk.gov.hmrc.test.ui.specs

import uk.gov.hmrc.test.ui.pages.partner.RelationshipStatusPage
import uk.gov.hmrc.test.ui.pages._
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

      TaskListPage.startApplicantSection()
      applicant.ApplicantNinoKnownPage.answerYes()
      applicant.ApplicantNinoPage.answer()
      applicant.ApplicantNamePage.answer()
      applicant.ApplicantHasPreviousFamilyNamePage.answerYes()
      applicant.ApplicantPreviousFamilyNamePage(1).answer()
      applicant.AddApplicantPreviousFamilyNamePage.remove(1)
      applicant.RemoveApplicantPreviousFamilyNamePage(1).answerNo()
      applicant.AddApplicantPreviousFamilyNamePage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.ApplicantNationalityPage(1).answer()
      applicant.AddApplicantNationalityPage.answerYes()
      applicant.ApplicantNationalityPage(2).answer()
      applicant.AddApplicantNationalityPage.remove(2)
      applicant.RemoveApplicantNationalityPage(2).answerYes()
      applicant.AddApplicantNationalityPage.answerNo()
      applicant.ApplicantHasAlwaysLivedInUkPage.answerYes()
      applicant.ApplicantCurrentUkAddressPage.answer()
      applicant.ApplicantIsHmfOrCivilServantPage.answerNo()
      applicant.ApplicantCurrentlyReceivingChildBenefitPage.answerNotClaiming()
      applicant.CheckApplicantDetailsPage.answer()

      TaskListPage.startPartnerDetails()
      partner.RelationshipStatusPage.answerSingle()
      partner.CheckPartnerDetailsPage.answer()

      TaskListPage.startChildDetails()
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
      child.GuardianNameKnownPage(1).answerYes()
      child.GuardianNamePage(1).answer()
      child.GuardianAddressKnownPage(1).answerYes()
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
      child.PreviousClaimantNameKnownPage(2).answerYes()
      child.PreviousClaimantNamePage(2).answer()
      child.PreviousClaimantAddressKnownPage(2).answerYes()
      child.PreviousClaimantAddressInUkPage(2).answerYes()
      child.PreviousClaimantUkAddressPage(2).answer()
      child.ChildLivesWithApplicantPage(2).answerNo()
      child.GuardianNameKnownPage(2).answerYes()
      child.GuardianNamePage(2).answer()
      child.GuardianAddressKnownPage(2).answerNo()
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
      child.PreviousClaimantNameKnownPage(3).answerYes()
      child.PreviousClaimantNamePage(3).answer()
      child.PreviousClaimantAddressKnownPage(3).answerYes()
      child.PreviousClaimantAddressInUkPage(3).answerNo()
      child.PreviousClaimantInternationalAddressPage(3).answer()
      child.ChildLivesWithApplicantPage(3).answerYes()
      child.ChildLivedWithAnyoneElsePage(3).answerNo()
      child.CheckChildDetailsPage(3).continue()

      child.AddChildPage.remove(1)
      child.RemoveChildPage(1).answerNo()
      child.AddChildPage.answerNo()

      TaskListPage.startPaymentDetails()
      payments.ApplicantIncomePage.answer()
      payments.WantToBePaidPage.answerYes()
      payments.ApplicantBenefitsPage.answer()
      payments.PaymentFrequencyPage.answerEveryFourWeeks()
      payments.ApplicantHasSuitableAccountPage.answerYes()
      payments.BankAccountHolderPage.answerApplicant()
      payments.AccountTypePage.answerSortCodeAccountNumber()
      payments.BankAccountDetailsPage.answer()
      payments.CheckPaymentDetails.answer()

      TaskListPage.startFurtherInformation()
      AdditionalInformationPage.answerWithInformation()

      TaskListPage.submitClaim()

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

      TaskListPage.startApplicantSection()
      applicant.ApplicantNinoKnownPage.answerNo()
      applicant.ApplicantNamePage.answer()
      applicant.ApplicantHasPreviousFamilyNamePage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.ApplicantNationalityPage(1).answer()
      applicant.AddApplicantNationalityPage.answerNo()
      applicant.ApplicantHasAlwaysLivedInUkPage.answerYes()
      applicant.ApplicantCurrentUkAddressPage.answer()
      applicant.ApplicantLivedAtCurrentAddressForOneYearPage.answerYes()
      applicant.ApplicantIsHmfOrCivilServantPage.answerNo()
      applicant.ApplicantCurrentlyReceivingChildBenefitPage.answerGettingPayments()
      applicant.EldestChildNamePage.answer()
      applicant.EldestChildDateOfBirthPage.answer()
      applicant.CheckApplicantDetailsPage.answer()

      TaskListPage.startPartnerDetails()
      partner.RelationshipStatusPage.answerMarried()
      partner.PartnerNamePage.answer()
      partner.PartnerNinoKnownPage.answerYes()
      partner.PartnerNinoPage.answer()
      partner.PartnerDateOfBirthPage.answer()
      partner.PartnerNationalityPage(1).answer()
      partner.AddPartnerNationalityPage.answerYes()
      partner.PartnerNationalityPage(2).answer()
      partner.AddPartnerNationalityPage.remove(2)
      partner.RemovePartnerNationalityPage(2).answerYes()
      partner.AddPartnerNationalityPage.answerNo()
      partner.PartnerIsHmfOrCivilServantPage.answerNo()
      partner.PartnerClaimingChildBenefitPage.answerGettingPayments()
      partner.PartnerEldestChildName.answer()
      partner.PartnerEldestChildDateOfBirthPage.answer()
      partner.CheckPartnerDetailsPage.answer()

      TaskListPage.startChildDetails()
      child.ChildNamePage(1).answer()
      child.ChildHasPreviousNamePage(1).answerNo()
      child.ChildBiologicalSexPage(1).answer()
      child.ChildDateOfBirthPage(1).answer()
      child.ChildBirthRegistrationCountryPage(1).answerEngland()
      child.BirthCertificateHasSystemNumberPage(1).answerNo()
      child.AdoptingThroughLocalAuthorityPage(1).answerNo()
      child.ApplicantRelationshipToChildPage(1).answer()
      child.AnyoneClaimedForChildBeforePage(1).answerYes()
      child.PreviousClaimantNameKnownPage(1).answerYes()
      child.PreviousClaimantNamePage(1).answer()
      child.PreviousClaimantAddressKnownPage(1).answerNo()
      child.ChildLivesWithApplicantPage(1).answerYes()
      child.ChildLivedWithAnyoneElsePage(1).answerYes()
      child.PreviousGuardianNameKnownPage(1).answerYes()
      child.PreviousGuardianNamePage(1).answer()
      child.PreviousGuardianAddressKnownPage(1).answerYes()
      child.PreviousGuardianAddressInUkPage(1).answerYes()
      child.PreviousGuardianUkAddressPage(1).answer()
      child.PreviousGuardianPhoneNumberKnownPage(1).answerYes()
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
      child.AnyoneClaimedForChildBeforePage(2).answerYes()
      child.PreviousClaimantNameKnownPage(2).answerNo()
      child.ChildLivesWithApplicantPage(2).answerYes()
      child.ChildLivedWithAnyoneElsePage(2).answerYes()
      child.PreviousGuardianNameKnownPage(2).answerYes()
      child.PreviousGuardianNamePage(2).answer()
      child.PreviousGuardianAddressKnownPage(2).answerYes()
      child.PreviousGuardianAddressInUkPage(2).answerNo()
      child.PreviousGuardianInternationalAddressPage(2).answer()
      child.PreviousGuardianPhoneNumberKnownPage(2).answerYes()
      child.PreviousGuardianPhoneNumberPage(2).answer()
      child.DateChildStartedLivingWithApplicantPage(2).answer()
      child.CheckChildDetailsPage(2).continue()
      child.AddChildPage.answerNo()

      TaskListPage.startPaymentDetails()
      payments.ApplicantOrPartnerIncomePage.answer()
      payments.WantToBePaidPage.answerYes()
      payments.ApplicantOrPartnerBenefitsPage.answerNoBenefits()
      payments.WantToBePaidToExistingAccountPage.answerYes()
      payments.CheckPaymentDetails.answer()

      TaskListPage.startFurtherInformation()
      AdditionalInformationPage.answerWithNoInformation()

      TaskListPage.submitClaim()

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

      TaskListPage.startApplicantSection()
      applicant.ApplicantNinoKnownPage.answerNo()
      applicant.ApplicantNamePage.answer()
      applicant.ApplicantHasPreviousFamilyNamePage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.ApplicantNationalityPage(1).answer()
      applicant.AddApplicantNationalityPage.answerNo()
      applicant.ApplicantHasAlwaysLivedInUkPage.answerNo()
      applicant.ApplicantUsuallyLivesInUk.answerNo()
      applicant.ApplicantUsualCountryOfResidence.answer()
      applicant.DateApplicantArrivedInUk.answer()
      applicant.ApplicantCurrentAddressInUkPage.answerYes()
      applicant.ApplicantCurrentUkAddressPage.answer()
      applicant.ApplicantLivedAtCurrentAddressForOneYearPage.answerNo()

      When("I answer that I have an international previous address")
      applicant.ApplicantPreviousAddressInUkPage.answerNo()
      applicant.ApplicantPreviousInternationalAddressPage.answer()

      Then("I must be able to continue the journey")
      applicant.ApplicantIsHmfOrCivilServantPage.answerNo()
    }

    Scenario("A person cohabiting with a partner", ZapTests) {

      Given("I am on the 'Relationship type' page")

      StartPage.loadPage()
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()

      TaskListPage.startApplicantSection()
      applicant.ApplicantNinoKnownPage.answerNo()
      applicant.ApplicantNamePage.answer()
      applicant.ApplicantHasPreviousFamilyNamePage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.ApplicantNationalityPage(1).answer()
      applicant.AddApplicantNationalityPage.answerNo()
      applicant.ApplicantHasAlwaysLivedInUkPage.answerYes()
      applicant.ApplicantCurrentUkAddressPage.answer()
      applicant.ApplicantLivedAtCurrentAddressForOneYearPage.answerYes()
      applicant.ApplicantIsHmfOrCivilServantPage.answerNo()
      applicant.ApplicantCurrentlyReceivingChildBenefitPage.answerGettingPayments()
      applicant.EldestChildNamePage.answer()
      applicant.EldestChildDateOfBirthPage.answer()
      applicant.CheckApplicantDetailsPage.answer()

      When("I answer that I am cohabiting with a partner")
      TaskListPage.startPartnerDetails()
      RelationshipStatusPage.answerCohabiting()

      Then("I must be shown the 'Cohabiting start date' page")
      partner.CohabitingDatePage.onPage()
    }

    Scenario("A person who is separated", ZapTests) {

      Given("I am on the 'Relationship type' page")

      StartPage.loadPage()
      StartPage.startNow()
      RecentlyClaimedPage.answerNo()

      TaskListPage.startApplicantSection()
      applicant.ApplicantNinoKnownPage.answerNo()
      applicant.ApplicantNamePage.answer()
      applicant.ApplicantHasPreviousFamilyNamePage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.ApplicantNationalityPage(1).answer()
      applicant.AddApplicantNationalityPage.answerNo()
      applicant.ApplicantHasAlwaysLivedInUkPage.answerYes()
      applicant.ApplicantCurrentUkAddressPage.answer()
      applicant.ApplicantLivedAtCurrentAddressForOneYearPage.answerYes()
      applicant.ApplicantIsHmfOrCivilServantPage.answerNo()
      applicant.ApplicantCurrentlyReceivingChildBenefitPage.answerGettingPayments()
      applicant.EldestChildNamePage.answer()
      applicant.EldestChildDateOfBirthPage.answer()
      applicant.CheckApplicantDetailsPage.answer()

      When("I answer that I am separated")
      TaskListPage.startPartnerDetails()
      RelationshipStatusPage.answerSeparated()

      Then("I must be shown the 'Separation date' page")
      partner.SeparationDatePage.onPage()
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

      TaskListPage.startApplicantSection()
      applicant.ApplicantNinoKnownPage.answerNo()
      applicant.ApplicantNamePage.answer()
      applicant.ApplicantHasPreviousFamilyNamePage.answerNo()
      applicant.ApplicantDateOfBirthPage.answer()
      applicant.ApplicantPhoneNumberPage.answer()
      applicant.ApplicantNationalityPage(1).answer()
      applicant.AddApplicantNationalityPage.answerNo()
      applicant.ApplicantHasAlwaysLivedInUkPage.answerYes()
      applicant.ApplicantCurrentUkAddressPage.answer()
      applicant.ApplicantLivedAtCurrentAddressForOneYearPage.answerYes()
      applicant.ApplicantIsHmfOrCivilServantPage.answerNo()
      applicant.ApplicantCurrentlyReceivingChildBenefitPage.answerNotClaiming()
      applicant.CheckApplicantDetailsPage.answer()

      TaskListPage.startPartnerDetails()
      partner.RelationshipStatusPage.answerMarried()
      partner.PartnerNamePage.answer()
      partner.PartnerNinoKnownPage.answerYes()
      partner.PartnerNinoPage.answer()
      partner.PartnerDateOfBirthPage.answer()
      partner.PartnerNationalityPage(1).answer()
      partner.AddPartnerNationalityPage.answerNo()
      partner.PartnerIsHmfOrCivilServantPage.answerNo()
      partner.PartnerClaimingChildBenefitPage.answerGettingPayments()
      partner.PartnerEldestChildName.answer()
      partner.PartnerEldestChildDateOfBirthPage.answer()
      partner.CheckPartnerDetailsPage.answer()

      TaskListPage.startChildDetails()
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

      TaskListPage.startPaymentDetails()
      payments.ApplicantOrPartnerIncomePage.answer()
      payments.WantToBePaidPage.answerYes()
      payments.ApplicantOrPartnerBenefitsPage.answerUniversalCredit()
      payments.PaymentFrequencyPage.answerWeekly()
      payments.ApplicantHasSuitableAccountPage.answerYes()
      payments.BankAccountHolderPage.answerJoint()
      payments.AccountTypePage.answerBuildingSociety()
      payments.BuildingSocietyDetails.answer()
      payments.CheckPaymentDetails.answer()

      TaskListPage.startFurtherInformation()
      AdditionalInformationPage.answerWithInformation()

      Then("I change my answers to indicate do not receive any benefits")
      TaskListPage.startPaymentDetails()
      payments.CheckPaymentDetails.changeBenefits()
      payments.ApplicantOrPartnerBenefitsPage.uncheckAnswers()
      payments.ApplicantOrPartnerBenefitsPage.answerNoBenefits()

      Then("I must be shown the 'You cannot be paid weekly' page")
      payments.CannotBePaidWeeklyPage.onPage()
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
  }
}
