package ie.ucd.lego.service

import ie.ucd.lego.composite.Invoice
import ie.ucd.lego.data.InvoiceRequest
import ie.ucd.lego.iterator.BlockingIterator

import java.util.Optional
import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.postfixOps
import ie.ucd.lego.*

trait InvoiceParserServiceComponent {
  this: QueueComponent =>
  val invoiceParserService: InvoiceParserService

  class InvoiceParserService(
//                              private val inQueue: BlockingQueue[InvoiceRequest],
//                              private val outQueue: BlockingQueue[Future[Invoice]]
                            ) extends Runnable :

    override def run() =
      while (true) {
        val value: InvoiceRequest = queues.invoiceParserInQueue.take()
        queues.invoiceParserOutQueue.offer(InvoiceParser(value).getInvoiceFuture)
      }


}


