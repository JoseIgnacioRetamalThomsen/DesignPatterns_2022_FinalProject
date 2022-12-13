import ie.ucd.lego.composite.Invoice
import ie.ucd.lego.{ComponentRequest, InvoiceRequest,InvoiceParserService,InvoiceProcessorService}

import java.util.concurrent.LinkedBlockingQueue
import scala.concurrent.Future

@main
def main(): Unit = {
  val componentRequest1 = ComponentRequest("Block_Solid", 1)
  val componentRequest2 = ComponentRequest("Block_Hollow", 1)
  val componentRequest3 = ComponentRequest("Window_Frames4", 1)
  val componentRequest4 = ComponentRequest("Door_WithHandle", 1)
  var list = List(componentRequest1, componentRequest2, componentRequest3, componentRequest4)
  var inQueue = new LinkedBlockingQueue[InvoiceRequest]()
  var outQueue = new LinkedBlockingQueue[Future[Invoice]]()
  var invoiceService = InvoiceParserService(inQueue, outQueue)
  var invoiceService1 = InvoiceProcessorService(outQueue)
  var t = new Thread(invoiceService)
  t.start()
  Thread(invoiceService1).start()
  inQueue.put(InvoiceRequest("1",list))

}