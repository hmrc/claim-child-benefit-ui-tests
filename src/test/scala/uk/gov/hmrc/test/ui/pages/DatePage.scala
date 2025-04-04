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

import org.openqa.selenium.By

import java.time.LocalDate

trait DatePage { this : BasePage =>

  def answerDate(date: LocalDate, field: String = "value"): Unit = {
    driver.findElement(By.id(s"$field.day")).sendKeys(date.getDayOfMonth.toString)
    driver.findElement(By.id(s"$field.month")).sendKeys(date.getMonth.getValue.toString)
    driver.findElement(By.id(s"$field.year")).sendKeys(date.getYear.toString)
  }
}
