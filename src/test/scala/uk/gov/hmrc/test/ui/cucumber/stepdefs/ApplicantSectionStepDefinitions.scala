package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages.StartPage.onPage
import uk.gov.hmrc.test.ui.pages.applicant
import uk.gov.hmrc.test.ui.pages.applicant.ApplicantNamePage.{continue, driver}
import uk.gov.hmrc.test.ui.pages.applicant.ApplicantPreviousFamilyNamePage


class ApplicantSectionStepDefinitions extends ScalaDsl with EN {

  When("""^I completed the Applicant section with details firstname (.*) lastname (.*) and family previous name (.*)""") { (firstName: String, lastName: String, prevName: String) =>
    driver.findElement(By.id("firstName")).sendKeys(firstName)
    driver.findElement(By.id("lastName")).sendKeys(lastName)
    continue()
    driver.findElement(By.id("value")).click()
    continue()
    applicant.ApplicantPreviousFamilyNamePage(1).answer(prevName)
    applicant.AddApplicantPreviousFamilyNamePage.remove(1)
    applicant.RemoveApplicantPreviousFamilyNamePage(1).answerNo()
    applicant.AddApplicantPreviousFamilyNamePage.answerNo()
    applicant.ApplicantDateOfBirthPage.answer()
    applicant.ApplicantPhoneNumberPage.answer()
    applicant.ApplicantNationalityPage(1).answerBritish()
    applicant.AddApplicantNationalityPage.answerYes()
    applicant.ApplicantNationalityPage(2).answerAmerican()
    applicant.AddApplicantNationalityPage.remove(2)
    applicant.RemoveApplicantNationalityPage(2).answerYes()
    applicant.AddApplicantNationalityPage.answerNo()
    applicant.ApplicantResidencePage.alwaysUk()
    applicant.ApplicantCurrentUkAddressPage.answer()
    applicant.ApplicantLivedAtCurrentAddressForOneYearPage.answerYes()
    applicant.ApplicantIsHmfOrCivilServantPage.answerNo()
    applicant.ApplicantCurrentlyReceivingChildBenefitPage.answerNotClaiming()
    applicant.CheckApplicantDetailsPage.answer()
  }
}
