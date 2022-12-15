package ie.ucd.lego.chain
import ie.ucd.lego.composite.{Invoice, InvoiceAmend}

class MinimumOrderProcess(nextProcessor: Option[Process], minAmount: Double, extraCharge: Double) extends Process(nextProcessor):
  override def process(invoice: Invoice): Invoice =
    if (invoice.getTotal < minAmount) {
      invoice.addAmmend(InvoiceAmend(extraCharge, "Extra charge for minimum order."))
    }
    super.process(invoice)


class DiscountProcess(nextProcessor: Option[Process], minAmount: Double, discountPerCent: Double) extends Process(nextProcessor):
  override def process(invoice: Invoice): Invoice =
    //println("processing")
    if (invoice.getTotal >= minAmount) {

      invoice.addAmmend(InvoiceAmend(-1*invoice.getTotal*discountPerCent, s"A ${discountPerCent*100} % discount.")) }
    super.process(invoice)

