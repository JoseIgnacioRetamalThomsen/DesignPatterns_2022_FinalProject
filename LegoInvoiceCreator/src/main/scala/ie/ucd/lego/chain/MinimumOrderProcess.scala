package ie.ucd.lego.chain
import ie.ucd.lego.composite.{Invoice, InvoiceAmend}

class MinimumOrderProcess(nextProcessor: Option[Process], minAmount: Double, extraCharge: Double) extends Process(nextProcessor):
  override def process(invoice: Invoice): Invoice =
    if (invoice.getTotal < minAmount) {
      invoice.addAmend(InvoiceAmend(extraCharge, "Extra charge for minimum order."))
    }
    super.process(invoice)




