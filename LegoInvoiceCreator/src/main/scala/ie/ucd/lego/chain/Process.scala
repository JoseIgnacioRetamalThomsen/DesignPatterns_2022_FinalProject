package ie.ucd.lego.chain

import ie.ucd.lego.composite.Invoice

trait Process(var nextProcessor: Option[Process]):
  def setNext(nextProcessor: Option[Process]): Unit =
    this.nextProcessor = nextProcessor

  def process(invoice: Invoice): Invoice =
    
    if !nextProcessor.isEmpty then nextProcessor.get.process(invoice) else
      invoice
