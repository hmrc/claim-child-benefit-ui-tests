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

trait BooleanPage { _: BasePage =>

  def answerYes(): Unit = {
    onPage()
    driver.findElement(By.id("value")).click()
    continue()
  }

  def answerNo(): Unit = {
    onPage()
    driver.findElement(By.id("value-no")).click()
    continue()
  }

  def answerMakeNewClaim(): Unit = {
    onPage()
    driver.findElement(By.id("serviceType")).click()
    continue()
  }

  def answerAddChildToExistingClaim(): Unit = {
    onPage()
    driver.findElement(By.id("serviceType-2")).click()
    continue()
  }

  def answerCheckOnProgressOfClaim(): Unit = {
    onPage()
    driver.findElement(By.id("serviceType-3")).click()
    continue()
  }

  def answerRestartYourPayment(): Unit = {
    onPage()
    driver.findElement(By.id("serviceType-4")).click()
    continue()
  }

  def answerStopYourPayment(): Unit = {
    onPage()
    driver.findElement(By.id("serviceType-5")).click()
    continue()
  }
}
