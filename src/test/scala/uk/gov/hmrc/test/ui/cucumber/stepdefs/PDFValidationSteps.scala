package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.pages.{DeclarationPage, TaskListPage}
import uk.gov.hmrc.test.ui.utils.FixedDelay

import java.io.File
import scala.jdk.CollectionConverters.CollectionHasAsScala

class PDFValidationSteps extends ScalaDsl with EN with Matchers {

  When("""^the PDF extracted and validated the data against the given form values during submission:$""") { (expectedValues: io.cucumber.datatable.DataTable) =>
    FixedDelay(3000)
    val downloadFolder = "/Users/admin/Downloads"
    val directory = new File(downloadFolder)
    val latestFile = directory.listFiles
      .filter(_.isFile)
      .filter(_.getName.toLowerCase.endsWith(".pdf"))
      .sortBy(_.lastModified())
      .lastOption

    latestFile match {
      case Some(file) =>
        // Perform further operations with the file
        val filePath = file.getAbsolutePath
        println(s"Latest downloaded file: $filePath")
      case None =>
        println("No PDF file found in the download folder.")
    }

    latestFile match {
      case Some(file) =>
        val filePath = file.getAbsolutePath
        // Open and read the PDF file
        val pdfDocument = PDDocument.load(new File(filePath))
        val pdfTextStripper = new PDFTextStripper()
        val extractedData = pdfTextStripper.getText(pdfDocument)

        val expectedValuesList = expectedValues.asLists().asScala.map(_.get(0))

        expectedValuesList.foreach { expectedValue =>
          extractedData should include(expectedValue)

          println(extractedData)
          latestFile.foreach { file =>
            file.delete() // Delete the latest PDF file
          }
        }
      case None =>
        println("No PDF file found in the download folder.")
    }

  }
  And("""^Accept and Declare the Terms and Conditions$""") { () =>
    TaskListPage.acceptAndContinue()
    DeclarationPage.acceptAndSend()
  }

  And("""^Download the PDF$""") { () =>
    TaskListPage.clickOnDownloadPDF()
  }
}
