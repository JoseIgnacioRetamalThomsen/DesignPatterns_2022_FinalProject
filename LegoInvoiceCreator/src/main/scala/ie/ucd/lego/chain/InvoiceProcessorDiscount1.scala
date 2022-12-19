package ie.ucd.lego.chain

import ie.ucd.lego.chain.Process
import ie.ucd.lego.composite.Invoice
import ie.ucd.lego.data.{InvoiceAmend, Lego}

import scala.collection.mutable.ArrayBuffer

class InvoiceProcessorDiscount1 extends InvoiceProcessor:
  addProcess(MinimumOrderProcess(Option.empty,100.0,25.0))
  addProcess(DiscountProcess(Option.empty,150,0.05))
  addProcess(DiscountProcess(Option.empty,350,0.05))








