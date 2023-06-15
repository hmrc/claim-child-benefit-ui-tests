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

package uk.gov.hmrc.test.ui.pages.child

import org.openqa.selenium.By
import org.scalatest.OptionValues
import uk.gov.hmrc.test.ui.pages.{BasePage, BooleanPage}

import scala.jdk.CollectionConverters._

object AddChildPage extends BasePage with BooleanPage with OptionValues {

  override val url: String = s"add-child"

  def remove(index: Int): Unit = {
    onPage()
    driver.findElements(By.xpath("//a[*/text() = 'Remove']")).asScala.lift(index - 1).value.click()
  }
}
