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
import org.scalacheck.Gen
import org.scalactic.source.Position
import org.scalatest.OptionValues

trait NinoPage extends OptionValues { _: BasePage =>

  private val arbitraryNino: Gen[String] =
    for {
      firstChar  <- Gen.oneOf('A', 'C', 'E', 'H', 'J', 'L', 'M', 'O', 'P', 'R', 'S', 'W', 'X', 'Y').map(_.toString)
      secondChar <-
        Gen
          .oneOf('A', 'B', 'C', 'E', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'T', 'W', 'X', 'Y', 'Z')
          .map(_.toString)
      digits     <- Gen.listOfN(6, Gen.numChar)
      lastChar   <- Gen.oneOf('A', 'B', 'C', 'D')
    } yield firstChar ++ secondChar ++ digits :+ lastChar

  private lazy val nino: String = arbitraryNino.sample.value

  def answer()(implicit pos: Position): Unit = {
    onPage()
    driver.findElement(By.id("value")).sendKeys(nino)
    continue()
  }
}
