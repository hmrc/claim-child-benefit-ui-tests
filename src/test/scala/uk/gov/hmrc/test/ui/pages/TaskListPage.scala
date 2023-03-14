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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.By

object TaskListPage extends BasePage {

  override val url: String = "task-list"

  def startApplicantSection(): Unit = {
    onPage()
    clickLink("Your details")
  }

  def startPartnerDetails(): Unit = {
    onPage()
    clickLink("Relationship details")
  }

  def startChildDetails(): Unit = {
    onPage()
    clickLink("Child details")
  }

  def startPaymentDetails(): Unit = {
    onPage()
    clickLink("Income details")
  }

  def startFurtherInformation(): Unit = {
    onPage()
    clickLink("Additional information")
  }

  def acceptAndContinue(): Unit = {
    onPage()
    driver.findElement(By.xpath("//button[contains(text(), 'Accept and continue')]")).click()
  }

  private def clickLink(content: String): Unit =
    driver.findElement(By.xpath(s"//a[text() = '$content']")).click()
}
