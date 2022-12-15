package ie.ucd.lego.decorator

import ie.ucd.lego.data.{Lego, Id}

abstract class AbstractComponentDecorator(componentDec: Lego) extends Lego :
  override def price: Double = componentDec.price

  override def id: Id = componentDec.id

  override def quantity: Int = componentDec.quantity

  override def toString: String = componentDec.toString
