package ie.ucd.lego.chain

import ie.ucd.lego.composite.Invoice

trait Processor(var nextProcessor: Option[Processor]):
  def setNext(nextProcessor: Option[Processor]): Unit =
    this.nextProcessor = nextProcessor

  def process(invoice: Invoice): Invoice =
    if !nextProcessor.isEmpty then nextProcessor.get.process(invoice) else
      invoice
