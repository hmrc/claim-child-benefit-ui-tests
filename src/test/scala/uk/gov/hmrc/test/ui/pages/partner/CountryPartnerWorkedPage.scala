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

package uk.gov.hmrc.test.ui.pages.partner

import org.scalactic.source.Position
import uk.gov.hmrc.test.ui.pages.BasePage

final case class CountryPartnerWorkedPage(index: Int) extends BasePage {

  override val url: String = s"country-partner-worked-in/$index"

  def answerSpain()(implicit pos: Position): Unit = {
    onPage()
    selectFromAutocomplete("value", "Spain")
    continue()
  }

  def answerGermany()(implicit pos: Position): Unit = {
    onPage()
    selectFromAutocomplete("value", "Germany")
    continue()
  }
}
