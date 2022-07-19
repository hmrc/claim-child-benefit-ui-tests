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

package uk.gov.hmrc.test.ui.pages.child

import org.openqa.selenium.By
import org.scalacheck.Gen
import org.scalactic.source.Position
import org.scalatest.OptionValues
import uk.gov.hmrc.test.ui.pages.BasePage

import java.time.Year

final case class ChildScottishBirthCertificateDetailsPage(index: Int) extends BasePage with OptionValues {

  override val url: String = s"child-scottish-birth-certificate-details/$index"

  private lazy val districtNumber: String = Gen.listOfN(3, Gen.numChar).map(_.mkString("")).sample.value
  private lazy val year: String           = Year.now.minusYears(1).toString
  private lazy val entryNumber: String    = (for {
    length <- Gen.chooseNum(1, 3)
    chars  <- Gen.listOfN(length, Gen.numChar)
  } yield chars.mkString("")).sample.value

  def answer()(implicit pos: Position): Unit = {
    onPage()
    driver.findElement(By.id("district")).sendKeys(districtNumber)
    driver.findElement(By.id("year")).sendKeys(year)
    driver.findElement(By.id("entryNumber")).sendKeys(entryNumber)
    continue()
  }
}
