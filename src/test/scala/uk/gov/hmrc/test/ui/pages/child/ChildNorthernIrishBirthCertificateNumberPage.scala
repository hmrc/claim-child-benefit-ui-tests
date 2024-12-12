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

final case class ChildNorthernIrishBirthCertificateNumberPage(index: Int) extends BasePage with OptionValues {

  override def url: String = s"child-birth-certificate-registration-number/$index"

  private lazy val digits: String             = Gen.listOfN(7, Gen.numChar).map(_.mkString("")).sample.value
  private lazy val registrationNumber: String = s"B1$digits"

  def answer(): Unit = {
    onPage()
    driver.findElement(By.id("value")).sendKeys(registrationNumber)
    continue()
  }
}
