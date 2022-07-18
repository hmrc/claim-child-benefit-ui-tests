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

final case class ChildBirthCertificateSystemNumberPage(index: Int) extends BasePage with OptionValues {

  override def url: String = s"child-birth-certificate-system-number/$index"

  private lazy val certificateSystemNumber: String = Gen.listOfN(9, Gen.numChar).map(_.mkString("")).sample.value

  def answer()(implicit pos: Position): Unit = {
    onPage()
    driver.findElement(By.id("value")).sendKeys(certificateSystemNumber)
    continue()
  }
}
