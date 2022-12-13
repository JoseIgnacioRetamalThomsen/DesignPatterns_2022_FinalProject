package ie.ucd.lego

import munit.FunSuite
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.{BlockingQueue, ConcurrentLinkedQueue}

class InvoiceServiceTest extends FunSuite {
  test("One"){
    var inQueue = new LinkedBlockingQueue[InvoiceRequest]()
    var invoiceService = InvoiceService(inQueue)
    var t = new Thread(invoiceService)
    t.start()

  }

}
