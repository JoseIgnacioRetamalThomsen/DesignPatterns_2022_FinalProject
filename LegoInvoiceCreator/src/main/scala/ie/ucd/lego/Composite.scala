package ie.ucd.lego

import scala.collection.mutable.ArrayBuffer

class Composite extends Component :
  val components = ArrayBuffer[Component]()

  def price: Double = components.map(_.price).sum

  def name: String = ???

  def id: Id = Id("Composite", "One")

  def addComponent(component: Component) = components += component

  override def toString =

    s"${id}\nTOTAL PRICE: €${price}"
