package ie.ucd.lego.decorator

import ie.ucd.lego.data.{Component, Id}

abstract class AbstractComponentDecorator(componentDec: Component) extends Component :
  override def price: Double = componentDec.price

  override def id: Id = componentDec.id

  override def toString: String = componentDec.toString
