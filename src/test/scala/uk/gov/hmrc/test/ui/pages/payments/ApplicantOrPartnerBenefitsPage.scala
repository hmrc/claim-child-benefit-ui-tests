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
import org.scalactic.source.Position
import uk.gov.hmrc.test.ui.pages.BasePage

import scala.collection.JavaConverters._

object ApplicantOrPartnerBenefitsPage extends BasePage {

  override val url: String = "your-or-your-partners-benefits"

  def answerUniversalCredit()(implicit pos: Position): Unit = {
    onPage()
    driver.findElement(By.id("value_4")).click()
    continue()
  }

  def uncheckAnswers()(implicit pos: Position): Unit = {
    onPage()
    driver.findElements(By.xpath("//input[@type = 'checkbox' and @checked]")).asScala.foreach(_.click())
  }

  def answerNoBenefits()(implicit pos: Position): Unit = {
    onPage()
    driver.findElement(By.id("value_5")).click()
    continue()
  }
}
