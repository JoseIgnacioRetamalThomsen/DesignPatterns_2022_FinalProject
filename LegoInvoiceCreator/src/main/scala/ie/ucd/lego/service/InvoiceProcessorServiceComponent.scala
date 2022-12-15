package ie.ucd.lego.service

import ie.ucd.lego.*
import ie.ucd.lego.cake.Components
import ie.ucd.lego.chain.*
import ie.ucd.lego.composite.Invoice
import ie.ucd.lego.data.InvoiceRequest
import ie.ucd.lego.iterator.{BlockingIterator, BlockingIteratorComponent, BlockingIteratorImp}

import java.util.Optional
import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.postfixOps

trait InvoiceProcessorServiceComponent {
  this: InvoiceProcessorComponent with QueueComponent with BlockingIteratorComponent[Invoice] =>
  val invoiceProcessorService: InvoiceProcessorService

  class InvoiceProcessorService extends Runnable :
    blockingIterator.setQueue(queues.invoiceParserOutQueue)

    override def run(): Unit =
      while (true) {
        blockingIterator.next.onComplete(invoice => println(invoiceProcessor.process(invoice.get)))
      }

}






