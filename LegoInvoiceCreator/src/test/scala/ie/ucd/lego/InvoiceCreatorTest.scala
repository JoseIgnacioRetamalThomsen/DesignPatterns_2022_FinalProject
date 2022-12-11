package ie.ucd.lego

import munit.FunSuite

class InvoiceCreatorTest extends FunSuite {
  test("that can print invoice proice"){
    val myInvoiceCreator = InvoiceCreator()
    println(myInvoiceCreator.invoice.toString)
    print(myInvoiceCreator.invoice.price)
    assertEquals(50.0, myInvoiceCreator.invoice.price)
  }

  test("test"){
  }
}
