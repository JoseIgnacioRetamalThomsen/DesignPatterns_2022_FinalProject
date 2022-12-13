package ie.ucd.lego

import ie.ucd.lego.composite.*
import ie.ucd.lego.data.Id
import ie.ucd.lego.prototype.ComponentPrototype

import java.util.concurrent.{ExecutorService, ForkJoinPool}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class InvoiceParser(invoiceRequest: InvoiceRequest):
  
  def getInvoiceFuture: Future[Invoice] =
    Future(getInvoice())

  private def getInvoice(): Invoice =
    val composite = Composite()
    invoiceRequest.components.foreach(c => {
      composite.addComponent(ComponentPrototype.getComponent(Id.fromString(c.id)))
    })
    Invoice(composite)
