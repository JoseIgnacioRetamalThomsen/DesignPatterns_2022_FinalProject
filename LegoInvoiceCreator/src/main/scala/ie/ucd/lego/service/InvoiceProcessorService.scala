package ie.ucd.lego.service

import ie.ucd.lego.cake.{Components, InvoiceProcessorComponent}
import ie.ucd.lego.chain.*
import ie.ucd.lego.composite.Invoice
import ie.ucd.lego.data.InvoiceRequest
import ie.ucd.lego.iterator.{BlockingIterator, BlockingIteratorComponent, BlockingIteratorImp}
import ie.ucd.lego.*

import java.util.Optional
import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.postfixOps

trait InvoiceProcessorServiceComponent {
  this: InvoiceProcessorComponent with QueueComponent with BlockingIteratorComponent[Invoice]=>
  val invoiceProcessorService: InvoiceProcessorService

  class InvoiceProcessorService( //private val inQueue: BlockingQueue[Future[Invoice]],

                                 //, private var invoiceProcessor: InvoiceProcessor
                               ) extends Runnable :
//    var blockingIterator = new BlockingIteratorImp[Invoice]()
    blockingIterator.setQueue(queues.invoiceParserOutQueue)

    override def run() =
      while (true) {
        blockingIterator.next.onComplete(invoice => println(invoiceProcessor.process(invoice.get)))
      }

}






