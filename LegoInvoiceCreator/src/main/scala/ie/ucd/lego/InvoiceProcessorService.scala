package ie.ucd.lego

import ie.ucd.lego.chain.InvoiceProcessor
import ie.ucd.lego.composite.Invoice

import java.util.Optional
import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.postfixOps

class InvoiceProcessorService(private val inQueue: BlockingQueue[Future[Invoice]]) extends Runnable :
  override def run() =
    while (true) {
      val value: Future[Invoice] = inQueue.take
      value.onComplete(invoice => {
        val in1 = InvoiceProcessor(invoice.get).process
        println(in1)
      })

    }



