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
import uk.gov.hmrc.test.ui.driver.StartUpTearDown
import uk.gov.hmrc.test.ui.utils.FixedDelay
import uk.gov.hmrc.test.ui.utils.exceptions.{Server500ResponseException, Server502ResponseException}

abstract class Page extends StartUpTearDown {

  def isOnPage: Boolean    = false
  def getPageTitle: String = webDriver.getTitle

  def clickOn(locator: String): Unit =
    webDriver.findElement(By.xpath("//*[@*='" + locator + "']")).click()

  def clickByID(id: String): Any =
    webDriver.findElement(By.id(s"$id")).click()

  def setField(id: String, value: String): Any = {
    webDriver.findElement(By.id(id)).clear()
    webDriver.findElement(By.id(id)).sendKeys(value)
  }

  def waitForPageToBeLoaded(condition: => Boolean, exceptionMessage: String, timeoutInSeconds: Int = 10): Unit = {
    val endTime = System.currentTimeMillis + timeoutInSeconds * 1000
    while (System.currentTimeMillis < endTime) {
      try if (condition) {
        return
      } catch {
        case _: RuntimeException =>
        // ignore exceptions during the timeout period because the condition
        // is throwing exceptions and we DO want to try the condition again until the timeout expires
      }
      // The following is to avoid to wait until timeout in case of well known errors
      val source: String = webDriver.getPageSource
      // 502
      if (source.contains("502 Bad Gateway")) {
        throw new Server502ResponseException
      }
      // GENERIC PLAY ERROR
      if (source.contains("play-error-page")) {
        throw new Server500ResponseException(
          "ERROR OCCURRED \n" + webDriver.findElement(By.cssSelector("#detail")).getText
        )
      }
      //IDA LOGIN UNEXPECTED ERROR
      if (source.contains("An unexpected problem occurred during authentication.")) {
        throw new Server500ResponseException("IDA Login Error")
      }
      FixedDelay(100)
    }
    throw new HmrcPageWaitException(exceptionMessage + "\nThe current page was:\n" + webDriver.getPageSource)
  }

  class HmrcPageWaitException(exceptionMessage: String) extends Exception(exceptionMessage)
}
