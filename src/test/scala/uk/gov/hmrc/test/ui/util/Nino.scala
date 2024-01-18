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

package uk.gov.hmrc.test.ui.util

import org.scalacheck.Gen
import org.scalatest.OptionValues

import scala.util.chaining.scalaUtilChainingOps

object Nino extends OptionValues {

  private val arbitraryNino: Gen[String] =
    for {
      firstChar    <- Gen.oneOf('A', 'C', 'E', 'H', 'J', 'L', 'M', 'O', 'P', 'R', 'S', 'W', 'X', 'Y').map(_.toString)
      secondChar   <-
        Gen
          .oneOf('A', 'B', 'C', 'E', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'T', 'W', 'X', 'Y', 'Z')
          .map(_.toString)
      firstDigits  <- Gen.listOfN(3, Gen.choose(1, 9)).map(_.mkString)
      secondDigits <- Gen.listOfN(3, Gen.numChar).map(_.mkString)
      lastChar     <- Gen.oneOf('A', 'B', 'C', 'D').map(_.toString)
    } yield firstChar + secondChar + firstDigits + secondDigits + lastChar

  def random(): String = arbitraryNino.sample.value

  def forSuccessfulSubmission(): String = random().pipe { nino =>
    nino.updated(7, '9')
  }

  def forFailedSubmission(): String = random().pipe { nino =>
    nino.updated(7, '7')
  }

  def forInvalidClaimState(): String = random().pipe { nino =>
    nino.updated(7, '4')
  }

  def forAlreadyInPayment(): String = random().pipe { nino =>
    nino.updated(7, '6')
  }

  def forPreviouslyClaimed(): String = random().pipe { nino =>
    nino.updated(7, '8')
  }
}
