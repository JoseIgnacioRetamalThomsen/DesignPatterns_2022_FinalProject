package ie.ucd.lego.service

import ie.ucd.lego.composite.*
import ie.ucd.lego.data.*
import ie.ucd.lego.service.QueueComponent

import java.util.concurrent.BlockingQueue
import scala.concurrent.ExecutionContext.Implicits.global

trait HtttpServiceComponent {
  this: QueueComponent =>
  val httpService: HttpService

  trait HttpService extends Runnable:
    def invoiceRequest(request: InvoiceRequest) : InvoiceResponse
    def sendInvoice(invoice:Invoice) : Unit

  class MockHttpService extends HttpService:

    new Thread(()=> println(Tests.tester1(queues.invoiceParserInQueue))).start()

    def invoiceRequest(request: InvoiceRequest): InvoiceResponse =
      queues.invoiceParserInQueue.offer(request)
      InvoiceResponse("OK")

    def sendInvoice(invoice:Invoice) : Unit =
      println(invoice)
    var totalOrderProcessed = 0
    override def run(): Unit =
      while (true) {
        sendInvoice(queues.invoiceDoneQueue.take())
        totalOrderProcessed += 1
        println(s"\n Total Orders Processed=${totalOrderProcessed} \n")
      }
}

object Tests:
  def tester1(queue:BlockingQueue[InvoiceRequest]):Unit=
    val rand = new scala.util.Random
      for(i <- 1 to 1000){
        var list = List(LegoRequest("Block_Solid", math.abs(rand.nextInt()%100)),
          LegoRequest("Block_Hollow", math.abs(rand.nextInt()%100)),
          LegoRequest("Window_Frames4", math.abs(rand.nextInt()%10)),
          LegoRequest("Door_WithHandle", math.abs(rand.nextInt()%10)))
        queue.offer(InvoiceRequest("Shop1_"+i,list))
      }

//    queue.offer(InvoiceRequest("Shop1_000001",list))
      val request = LegoRequest("Room_Basic",1)
      val componentRequest1 = LegoRequest("Block_Solid", 10)
      var list1 = List(request,componentRequest1)
      println(InvoiceRequest("Shop1_000002",list1))
      queue.offer(InvoiceRequest("Shop1_000002",list1))



