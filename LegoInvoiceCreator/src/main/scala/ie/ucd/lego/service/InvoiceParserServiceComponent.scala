package ie.ucd.lego.service

import ie.ucd.lego.*
import ie.ucd.lego.composite.Invoice
import ie.ucd.lego.data.InvoiceRequest
import ie.ucd.lego.iterator.BlockingIterator

import java.util.Optional
import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.postfixOps

trait InvoiceParserServiceComponent {
  this: QueueComponent =>
  val invoiceParserService: InvoiceParserService

  class InvoiceParserService extends Runnable :
    override def run(): Unit =
      while (true) {
        queues.invoiceParserOutQueue.offer(InvoiceParser(queues.invoiceParserInQueue.take()).getInvoiceFuture)
      }
}


