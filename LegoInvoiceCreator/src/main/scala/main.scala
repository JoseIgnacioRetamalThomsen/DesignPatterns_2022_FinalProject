import ie.ucd.lego.composite.Invoice
import ie.ucd.lego.data.{ComponentRequest, InvoiceRequest}
import ie.ucd.lego.{InvoiceParserService,InvoiceProcessorService}
import ie.ucd.lego.chain.*

import java.util.concurrent.LinkedBlockingQueue
import scala.concurrent.Future
import ie.ucd.lego.iterator.BlockingIteratorImp

@main
def main(): Unit = {
  println("starr")
  val componentRequest1 = ComponentRequest("Block_Solid", 1)
  val componentRequest2 = ComponentRequest("Block_Hollow", 1)
  val componentRequest3 = ComponentRequest("Window_Frames4", 1)
  val componentRequest4 = ComponentRequest("Door_WithHandle", 1)

  var invoiceProcessor: InvoiceProcessor = InvoiceProcessorImp()
  invoiceProcessor.addProcess(MinimumOrderProcess(Option.empty,100.0,25.0))
  invoiceProcessor.addProcess(MinimumOrderProcess(Option.empty,100.0,20.0))
  invoiceProcessor.addProcess(MinimumOrderProcess(Option.empty,100.0,15.0))
  var list = List(componentRequest1, componentRequest2, componentRequest3, componentRequest4)
  var inQueue = new LinkedBlockingQueue[InvoiceRequest]()
  var outQueue = new LinkedBlockingQueue[Future[Invoice]]()
  var invoiceService = InvoiceParserService(inQueue, outQueue)
  var invoiceService1 = InvoiceProcessorService(outQueue,BlockingIteratorImp[Invoice](), invoiceProcessor)
  var t = new Thread(invoiceService)
  t.start()
  Thread(invoiceService1).start()
  inQueue.put(InvoiceRequest("1",list))

}