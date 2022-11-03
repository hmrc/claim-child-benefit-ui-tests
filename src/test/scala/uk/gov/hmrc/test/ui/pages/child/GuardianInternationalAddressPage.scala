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
import org.scalactic.source.Position
import uk.gov.hmrc.test.ui.pages.BasePage

final case class GuardianInternationalAddressPage(index: Int) extends BasePage {

  override val url: String = s"person-child-lives-with-international-address/$index"

  def answer()(implicit pos: Position): Unit = {
    onPage()
    driver.findElement(By.id("line1")).sendKeys("1 Test Street")
    driver.findElement(By.id("town")).sendKeys("Test Town")
    driver.findElement(By.id("postcode")).sendKeys("ZZ1 1ZZ")
    selectFromAutocomplete("country", "FR")
    continue()
  }
}
