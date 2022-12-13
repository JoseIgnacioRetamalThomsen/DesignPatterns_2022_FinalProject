package ie.ucd.lego.composite

import ie.ucd.lego.data.{Component, Id}

import scala.collection.mutable.ArrayBuffer

class Composite extends Component :
  val components = ArrayBuffer[Component]()

  def price: Double = components.map(_.price).sum

  def name: String = id.componentType

  def id: Id = Id("Composite", "One")

  def addComponent(component: Component) = components += component

  override def toString =
    val s = components.map(_.toString).mkString("\n")

    s"\n${id}\n${s}\nTOTAL PRICE: €${price}"
