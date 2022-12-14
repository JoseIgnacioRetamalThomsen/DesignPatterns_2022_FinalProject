package ie.ucd.lego

import ie.ucd.lego.chain.InvoiceProcessorImp
import ie.ucd.lego.composite.Invoice
import ie.ucd.lego.iterator.{BlockingIterator, BlockingIteratorImp}

import java.util.Optional
import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.postfixOps
import ie.ucd.lego.chain.*

class InvoiceProcessorService(private val inQueue: BlockingQueue[Future[Invoice]],
                              private var blockingIterator: BlockingIterator[Invoice],
                              private var invoiceProcessor: InvoiceProcessor ) extends Runnable :
  blockingIterator.setQueue(inQueue)
  
  override def run() =
    while (true) {
        blockingIterator.next.onComplete(invoice => println(invoiceProcessor.process(invoice.get)))
    }



