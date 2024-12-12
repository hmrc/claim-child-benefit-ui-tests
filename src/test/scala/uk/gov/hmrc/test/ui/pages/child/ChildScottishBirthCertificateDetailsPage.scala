/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages.child

import org.openqa.selenium.By
import org.scalacheck.Gen
import org.scalatest.OptionValues
import uk.gov.hmrc.test.ui.pages.BasePage

import java.time.LocalDate

final case class ChildScottishBirthCertificateDetailsPage(index: Int) extends BasePage with OptionValues {

  override val url: String = s"child-scottish-birth-certificate-details/$index"

  private lazy val district = Gen.choose(100, 999).sample.value.toString
  private lazy val maxYear  = LocalDate.now.getYear
  private lazy val minYear  = maxYear - 20
  private lazy val year     = Gen.choose(minYear, maxYear).sample.value.toString
  private lazy val entry    = Gen.choose(1, 999).sample.value.toString

  def answer(): Unit = {
    onPage()
    driver.findElement(By.id("district")).sendKeys(district)
    driver.findElement(By.id("year")).sendKeys(year)
    driver.findElement(By.id("entry")).sendKeys(entry)
    continue()
  }
}
