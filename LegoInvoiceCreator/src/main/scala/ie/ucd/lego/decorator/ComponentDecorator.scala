package ie.ucd.lego.decorator

import ie.ucd.lego.data.{Lego, PricesServices}

class ComponentDecorator(componentDec: Lego) extends AbstractComponentDecorator(componentDec) :
  override def price: Double = PricesServices.getUpdatedPrice(id, super.price)

  override def toString = s"${id.componentType}_${id.componentDetails} €${price}"
