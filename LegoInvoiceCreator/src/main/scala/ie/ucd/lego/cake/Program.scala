package ie.ucd.lego.cake

import ie.ucd.lego.composite.Invoice
import ie.ucd.lego.service.*
import ie.ucd.lego.iterator.*
import ie.ucd.lego.*
import ie.ucd.lego.chain.*

object Program extends Components :
  val queues = QueueImp()
  val blockingIterator = BlockingIteratorImp[Invoice]()
  val invoiceProcessorService = InvoiceProcessorService()
  val invoiceProcessor = InvoiceProcessorImp()
  val invoiceParserService = InvoiceParserService()

  def startService =
    Thread(invoiceProcessorService).start()
    Thread(invoiceParserService).start()
