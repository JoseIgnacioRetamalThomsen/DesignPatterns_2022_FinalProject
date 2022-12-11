package ie.ucd.lego

import scala.collection.mutable.ArrayBuffer
import collection.mutable.{Map, ListBuffer}

class InvoiceCreator:
  val invoice = Composite()
  invoice.addComponent(Creator.getComponent(Id("Block","Solid")))
  invoice.addComponent(Block(id = Id("BLock","Hollow")))
  invoice.addComponent(Window())
  invoice.addComponent(Door())

@main def main(): Unit =
  val myInvoiceCreator = InvoiceCreator()
  println(myInvoiceCreator.invoice.toString)
