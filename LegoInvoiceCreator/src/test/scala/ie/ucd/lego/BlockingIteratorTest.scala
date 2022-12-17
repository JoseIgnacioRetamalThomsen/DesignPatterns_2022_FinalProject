package ie.ucd.lego

import ie.ucd.lego.composite.Invoice
import munit.FunSuite

import java.util.concurrent.LinkedBlockingQueue
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import munit.Clue.generate
import ie.ucd.lego.data.{LegoRequest, InvoiceRequest}
import ie.ucd.lego.iterator.{BlockingIterator,BlockingIteratorImp}

class BlockingIteratorTest extends FunSuite {
  def rumMe(outQueue:LinkedBlockingQueue[Future[Invoice]],list : List[LegoRequest] ):Unit =
    Thread.sleep(200)
    outQueue.offer(InvoiceParser(InvoiceRequest("1", list)).getInvoiceFuture)
    outQueue.offer(InvoiceParser(InvoiceRequest("2", list)).getInvoiceFuture)
    outQueue.offer(InvoiceParser(InvoiceRequest("3", list)).getInvoiceFuture)
    Thread.sleep(500)
    outQueue.offer(InvoiceParser(InvoiceRequest("4", list)).getInvoiceFuture)
    Thread.sleep(5000)
    outQueue.offer(InvoiceParser(InvoiceRequest("5", list)).getInvoiceFuture)
    Thread.sleep(100)
    outQueue.offer(InvoiceParser(InvoiceRequest("6", list)).getInvoiceFuture)

test("ttest"){
  val outQueue = new LinkedBlockingQueue[Future[Invoice]]()
  val objectUnderTest = BlockingIteratorImp[Invoice](outQueue)

  val componentRequest1 = LegoRequest("Block_Solid", 1)
  val componentRequest2 = LegoRequest("Block_Hollow", 1)
  val componentRequest3 = LegoRequest("Window_Frames4", 1)
  val componentRequest4 = LegoRequest("Door_WithHandle", 1)
  val list = List(componentRequest1, componentRequest2, componentRequest3, componentRequest4)
  new Thread(() => {rumMe(outQueue,list)}
  ).run()

  for(i <- 1 to 6){
    println(objectUnderTest.next)
    println(i)
  }
 println("Done")

}
}
