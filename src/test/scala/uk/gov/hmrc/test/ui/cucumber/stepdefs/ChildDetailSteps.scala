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

import uk.gov.hmrc.test.ui.pages.{DeclarationPage, RecentlyClaimedPage, SignInPage, StartPage, TaskListPage, applicant, child, partner, payments}

class ChildDetailSteps extends BaseDetailsSteps {


  Then("""^I navigate to child details page and completed the child details with (.*) and (.*)$""") { (firstName: String, lastName: String) =>
    TaskListPage.startChildDetails()
    child.ChildNamePage(1).enterUserDetails(firstName, lastName)
    child.ChildHasPreviousNamePage(1).answerNo()
    child.ChildDateOfBirthPage(1).answer()
    child.ChildBiologicalSexPage(1).answer()
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
  }

  Then("""^Adding the second child details with (.*) and (.*)$""") { (firstName: String, lastName: String) =>
    child.AddChildPage.answerYes()
    child.ChildNamePage(2).enterUserDetails(firstName, lastName)
    child.ChildHasPreviousNamePage(2).answerYes()
    child.ChildNameChangedByDeedPollPage(2).answerYes()
    child.ChildPreviousNamePage(2, 1).answer()
    child.AddChildPreviousNamePage(2).remove(1)
    child.RemoveChildPreviousNamePage(2, 1).answerNo()
    child.AddChildPreviousNamePage(2).answerNo()
    child.ChildDateOfBirthPage(2).answer()
    child.ChildBiologicalSexPage(2).answer()
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
  }
  Then("""^Adding the third child details with (.*) and (.*)$""") { (firstName: String, lastName: String) =>
    child.AddChildPage.answerYes()
    child.ChildNamePage(3).enterUserDetails(firstName, lastName)
    child.ChildHasPreviousNamePage(3).answerNo()
    child.ChildDateOfBirthPage(3).answer()
    child.ChildBiologicalSexPage(3).answer()
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
  }
  
}
