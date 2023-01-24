package uk.gov.hmrc.test.ui.pages.applicant

import uk.gov.hmrc.test.ui.pages.BasePage

object ApplicantUsualCountryOfResidence extends BasePage {

  override val url: String = "usual-country-of-residence"

  def answer(): Unit = {
    onPage()
    selectFromAutocomplete("value", "Spain")
    continue()
  }
}
