package ie.ucd.lego.service

import ie.ucd.lego.composite.Invoice
import ie.ucd.lego.data.InvoiceRequest

import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
import scala.concurrent.Future

trait QueueComponent:
  val queues: QueueTrait

trait QueueTrait:
  val invoiceParserInQueue: BlockingQueue[InvoiceRequest]
  val invoiceParserOutQueue: BlockingQueue[Future[Invoice]]
  val invoiceDoneQueue: BlockingQueue[Invoice]


class QueueImp extends QueueTrait :
  val invoiceParserInQueue: BlockingQueue[InvoiceRequest] = LinkedBlockingQueue[InvoiceRequest]()
  val invoiceParserOutQueue: BlockingQueue[Future[Invoice]] = LinkedBlockingQueue[Future[Invoice]]()
  val invoiceDoneQueue: BlockingQueue[Invoice] = LinkedBlockingQueue[Invoice]()
