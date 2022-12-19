package ie.ucd.lego.composite

import ie.ucd.lego.data.{Lego, Id}

import scala.collection.mutable.ArrayBuffer

case class InvoiceComposite(compositeId:Id,quantity: Int = 1) extends Lego :
  val components = ArrayBuffer[Lego]()

  def price: Double =
    components.map(component =>component.quantity*component.price).sum

  def name: String = id.componentType

  def id: Id = compositeId

  def addComponent(component: Lego) = components += component

  def myCopy(quantity: Int =1): InvoiceComposite =
      val copy = InvoiceComposite(compositeId, quantity)
      components.foreach(c => copy.addComponent(c))
      copy
  override def toString =
    var result = s"Invoice #${id.componentDetails} shop ${id.componentType}\n\nDetails:\n"
    result += components.map(_.toString).mkString("\n")
    result += s"\n\nPrice Before Amends: €${price}\n"
    result += s"\n\nAmends:\n"
    result
