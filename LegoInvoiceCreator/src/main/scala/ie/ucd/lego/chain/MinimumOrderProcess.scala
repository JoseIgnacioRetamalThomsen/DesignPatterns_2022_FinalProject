package ie.ucd.lego.chain
import ie.ucd.lego.composite.{Invoice, InvoiceAmend}

class MinimumOrderProcess(nextProcessor: Option[Processor], minAmount: Double, extraCharge: Double) extends Processor(nextProcessor) :
  override def process(invoice: Invoice): Invoice =
    if (invoice.getTotal < minAmount) {
      invoice.addAmmend(InvoiceAmend(extraCharge, "Extra charge for minimum order."))
    }
    if !nextProcessor.isEmpty then nextProcessor.get.process(invoice) else
      invoice
