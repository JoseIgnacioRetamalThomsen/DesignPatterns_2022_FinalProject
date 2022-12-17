package ie.ucd.lego

import ie.ucd.lego.composite.*
import ie.ucd.lego.data.{Id, InvoiceRequest}
import ie.ucd.lego.decorator.LegoDecorator
import ie.ucd.lego.prototype.LegoPrototype

import java.util.concurrent.{ExecutorService, ForkJoinPool}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class InvoiceParser(invoiceRequest: InvoiceRequest):
  def getInvoiceFuture: Future[Invoice] =
    Future(getInvoice)

  private def getInvoice: Invoice =
    val composite = InvoiceComposite(Id.fromString(invoiceRequest.invoiceId))
    invoiceRequest.components.foreach(c => {
      composite.addComponent(LegoDecorator(LegoPrototype.getComponent(Id.fromString(c.id),c.amount)))
    })
    Invoice(composite)
