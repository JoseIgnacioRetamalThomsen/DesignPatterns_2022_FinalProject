package ie.ucd.lego.composite

import ie.ucd.lego.composite.InvoiceComposite

import scala.collection.mutable.ListBuffer

class Invoice(val composite: InvoiceComposite):
  val amends: ListBuffer[InvoiceAmend] = ListBuffer()
  
  def addAmend(amend: InvoiceAmend): Unit = amends += amend

  def quantity: Int = 5

  override def toString: String =
    var result = s"Invoice #${composite.id.componentDetails} shop ${composite.id.componentType}\n\nDetails:\n"
    result += composite.components.map(_.toString).mkString("\n")
    result += s"\n\nPrice Before Amends: €${composite.price}\n"
    result += s"\nAmends:\n"
    result += amends.map(_.toString).mkString("\n")
    result += s"\n\nTOTAL: €${getTotal}"
    result

  def getTotal: Double =
    composite.price + getTotalAmends

  def getTotalAmends: Double =
    amends.map(_.amount).sum

case class InvoiceAmend(amount: Double, description: String):
  override def toString: String = s"${description} amount: €${amount}"

