package ie.ucd.lego

import ie.ucd.lego.composite.Invoice

import java.util.Optional
import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.postfixOps

class InvoiceParserService(
                      private val inQueue: BlockingQueue[InvoiceRequest],
                      private val outQueue: BlockingQueue[Future[Invoice]]
                    ) extends Runnable :
  override def run() =
    while (true) {
      val value: InvoiceRequest = inQueue.take
      outQueue.offer(InvoiceParser(value).getInvoiceFuture)
    }






