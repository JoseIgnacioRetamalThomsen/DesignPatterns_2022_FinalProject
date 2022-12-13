package ie.ucd.lego.chain

import ie.ucd.lego.chain.Processor
import ie.ucd.lego.composite.{Invoice, InvoiceAmend}

class InvoiceProcessor(invoice: Invoice):
  val chain : Processor =  MinimumOrderProcess(Option.empty,100.0,30.0)
  chain.nextProcessor = Option(MinimumOrderProcess(Option.empty,100.0,30.0))

  def process:Invoice=
    chain.process(invoice)










