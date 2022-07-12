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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver

trait BasePage extends BrowserDriver with Matchers {

  def title: String

  def continue(): Unit =
    driver.findElement(By.xpath("//button[contains(text(), 'Continue')]")).click()

  def onPage(): Unit =
    if (driver.getTitle != s"$title - Claim Child Benefit - GOV.UK")
      throw PageNotFoundException(
        s"Expected '$title' page, but found '${driver.getTitle}' page."
      )
}

case class PageNotFoundException(s: String) extends Exception(s)
