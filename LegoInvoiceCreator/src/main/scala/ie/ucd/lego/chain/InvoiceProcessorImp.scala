package ie.ucd.lego.chain

import ie.ucd.lego.chain.Process
import ie.ucd.lego.composite.{Invoice, InvoiceAmend}
import ie.ucd.lego.data.Component

import scala.collection.mutable.ArrayBuffer

class InvoiceProcessorImp extends InvoiceProcessor:
  addProcess(MinimumOrderProcess(Option.empty,100.0,25.0))
  addProcess(DiscountProcess(Option.empty,150,0.05))
  addProcess(DiscountProcess(Option.empty,350,0.05))

class InvoiceProcessorSuperDiscount extends InvoiceProcessor:
  addProcess(MinimumOrderProcess(Option.empty,100.0,25.0))
  addProcess(DiscountProcess(Option.empty,100,0.05))
  addProcess(DiscountProcess(Option.empty,150,0.1))
//  val components = ArrayBuffer[Process]()
//  var chain : Process =  MinimumOrderProcess(Option.empty,100.0,25.0)
//  chain.nextProcessor = Option.empty
//
//  def addProcess(process: Process): Unit =
//    components += process
//    chain = components(0)
//    var chainRef = chain
//    for (i <- 1 until components.size){
//      chainRef.nextProcessor = Option(components(i))
//      chainRef = components(i)
//    }
//
//  def removeAllProcess: Unit = components.clear()
//
//  def process(invoice: Invoice): Invoice =
//    chain.process(invoice)








