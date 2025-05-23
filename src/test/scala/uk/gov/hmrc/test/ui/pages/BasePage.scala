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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{By, WebElement}
import org.scalactic.source.Position
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.scalatest.matchers.must.Matchers
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.driver.BrowserDriver

trait BasePage extends BrowserDriver with Matchers {

  def url: String

  def continue()(implicit pos: Position): Unit =
    driver.findElement(By.xpath("//button[contains(text(), 'Continue')]")).click()

  def onPage()(implicit pos: Position): Unit =
    driver.getCurrentUrl must startWith(s"${TestConfiguration.url("claim-child-benefit-frontend")}/$url")

  def waitForElement(by: By): WebElement =
    new FluentWait(driver)
      .until {
        ExpectedConditions.presenceOfElementLocated(by)
      }

  def selectFromAutocomplete(inputId: String, data: String): Unit = {
    driver.findElement(By.id(inputId)).click()
    waitForElement(By.id(inputId))
    driver.findElement(By.id(inputId)).sendKeys(data)
    waitForElement(By.id(inputId))
    driver.findElement(By.id(s"${inputId}__option--0")).click()
  }
}
