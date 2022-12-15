package ie.ucd.lego.cake

import ie.ucd.lego.chain.InvoiceProcessor

trait InvoiceProcessorComponent:
  val invoiceProcessor: InvoiceProcessor
