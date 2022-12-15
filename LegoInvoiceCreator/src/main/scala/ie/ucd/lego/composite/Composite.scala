package ie.ucd.lego.composite

import ie.ucd.lego.data.{Lego, Id}

import scala.collection.mutable.ArrayBuffer

class Composite extends Lego :
  val components = ArrayBuffer[Lego]()

  def price: Double =
    //components.map(_.price).sum
    components.map(component =>component.quantity*component.price).sum

  def name: String = id.componentType

  def id: Id = Id("Composite", "One")

  def quantity: Int = 1

  def addComponent(component: Lego) = components += component

  override def toString =
    val s = components.map(_.toString).mkString("\n")

    s"\n${id}\n${s}\nTOTAL PRICE: €${price}"
