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

package uk.gov.hmrc.test.ui.pages.payments

import org.openqa.selenium.By
import org.scalacheck.Gen
import org.scalactic.source.Position
import org.scalatest.OptionValues
import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.test.ui.pages.applicant.ApplicantUsualCountryOfResidence.selectFromAutocomplete

object BuildingSocietyDetails extends BasePage with OptionValues {

  override val url: String = "building-society-details"

  private lazy val rollNumber: String = Gen.listOfN(10, Gen.numChar).map(_.mkString("")).sample.value

  def answer()(implicit pos: Position): Unit = {
    onPage()
    driver.findElement(By.id("firstName")).sendKeys("F")
    driver.findElement(By.id("lastName")).sendKeys("Bar")
    selectFromAutocomplete("buildingSociety", "Abbey / Santander")
    driver.findElement(By.id("rollNumber")).sendKeys(rollNumber)
    continue()
  }
}
