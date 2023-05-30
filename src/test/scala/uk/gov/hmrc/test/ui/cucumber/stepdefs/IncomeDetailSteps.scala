package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import uk.gov.hmrc.test.ui.pages.{TaskListPage, payments}

class IncomeDetailSteps extends ScalaDsl with EN {
  Then("""^Adding the Income details$""") { () =>
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
  }
}
