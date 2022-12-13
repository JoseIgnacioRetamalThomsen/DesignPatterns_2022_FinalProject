package ie.ucd.lego.composite

import ie.ucd.lego.composite.Composite

import scala.collection.mutable.ListBuffer

class Invoice(val composite: Composite):
  val amends: ListBuffer[InvoiceAmend] = ListBuffer()

  def addAmmend(ammend : InvoiceAmend) : Unit = amends += ammend

  def getTotal: Double =
    composite.price


  def quantity: Int = 5

  override def toString: String =
    println(amends)
    composite.toString

case class InvoiceAmend(amount: Double, description: String)

