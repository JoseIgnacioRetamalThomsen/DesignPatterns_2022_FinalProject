package ie.ucd.lego.chain

import ie.ucd.lego.chain.InvoiceProcessor

trait InvoiceProcessorComponent:
  val invoiceProcessor: InvoiceProcessor
