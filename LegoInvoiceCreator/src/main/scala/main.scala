import ie.ucd.lego.cake.Program
import ie.ucd.lego.composite.Invoice
import ie.ucd.lego.data.{ComponentRequest, InvoiceRequest}
import ie.ucd.lego.chain.*

import java.util.concurrent.LinkedBlockingQueue
import scala.concurrent.Future
import ie.ucd.lego.iterator.BlockingIteratorImp

@main
def main(): Unit = {
  val componentRequest1 = ComponentRequest("Block_Solid", 1)
  val componentRequest2 = ComponentRequest("Block_Hollow", 1)
  val componentRequest3 = ComponentRequest("Window_Frames4", 1)
  val componentRequest4 = ComponentRequest("Door_WithHandle", 1)
  var list = List(componentRequest1, componentRequest2, componentRequest3, componentRequest4)
  list = list :+ ComponentRequest("Window_Frames4", 1)
  list = list :+ ComponentRequest("Window_Frames4", 1)
  list = list :+ ComponentRequest("Window_Frames4", 1)
  list = list :+ ComponentRequest("Window_Frames4", 1)
  list = list :+ ComponentRequest("Window_Frames4", 1)
  list = list :+ ComponentRequest("Window_Frames4", 1)
  list = list :+ ComponentRequest("Window_Frames4", 1)
  list = list :+ ComponentRequest("Window_Frames4", 1)
  list = list :+ ComponentRequest("Window_Frames4", 1)
  Program.startService()
  Program.queues.invoiceParserInQueue.put(InvoiceRequest("1",list))

}

