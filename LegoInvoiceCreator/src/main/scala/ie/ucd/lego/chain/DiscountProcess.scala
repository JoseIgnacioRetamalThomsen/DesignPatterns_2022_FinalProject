package ie.ucd.lego.chain

import ie.ucd.lego.composite.Invoice
import ie.ucd.lego.data.InvoiceAmend

class DiscountProcess(nextProcessor: Option[Process], minAmount: Double, discountPerCent: Double) extends Process(nextProcessor) :
  override def process(invoice: Invoice): Invoice =
    //println("processing")
    if (invoice.getTotal >= minAmount) {

      invoice.addAmend(InvoiceAmend(-1 * invoice.getTotal * discountPerCent, s"A ${discountPerCent * 100} % discount."))
    }
    super.process(invoice)
