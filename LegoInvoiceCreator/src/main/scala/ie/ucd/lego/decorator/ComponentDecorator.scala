package ie.ucd.lego.decorator

import ie.ucd.lego.data.{Component, PricesServices}

class ComponentDecorator(componentDec: Component) extends AbstractComponentDecorator(componentDec) :
  override def price: Double = PricesServices.getUpdatedPrice(id, super.price)

  override def toString = s"${id.componentType}_${id.componentDetails} €${price}"
