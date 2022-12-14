package ie.ucd.lego

import scala.collection.mutable.ArrayBuffer
import collection.mutable.{ListBuffer, Map}
import ie.ucd.lego.composite.*
import ie.ucd.lego.data.Id
import prototype.ComponentPrototype
// to remove
class InvoiceCreator:
  val invoice = Composite()
  println("Im called")
  invoice.addComponent(ComponentPrototype.getComponent(Id("Block","Solid")))
  invoice.addComponent(ComponentPrototype.getComponent(Id("Block","Hollow")))
  invoice.addComponent(ComponentPrototype.getComponent(Id("Window","Frames4")))
  invoice.addComponent(ComponentPrototype.getComponent(Id("Door","WithHandle")))

//@main def main(): Unit =
//  val myInvoiceCreator = InvoiceCreator()
//  println(myInvoiceCreator.invoice.toString)
