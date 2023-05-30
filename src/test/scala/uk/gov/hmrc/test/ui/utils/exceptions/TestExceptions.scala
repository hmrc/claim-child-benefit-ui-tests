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

package uk.gov.hmrc.test.ui.utils.exceptions

class Server502ResponseException extends Exception("Server has returned a 502 Bad Gateway Response")

class Server500ResponseException(stackTraceMessage: String) extends Exception(stackTraceMessage)

class TransactionNotFoundException(authorityId: String)
    extends Exception(s"Unable to find a transaction for authorityId: $authorityId")
