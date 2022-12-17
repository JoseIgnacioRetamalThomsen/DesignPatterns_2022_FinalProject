package ie.ucd.lego.decorator

import ie.ucd.lego.data.Lego
import ie.ucd.lego.service.PricesServices

class LegoDecorator(componentDec: Lego) extends AbstractLegoDecorator(componentDec) :
  override def price: Double = PricesServices.getUpdatedPrice(id, super.price)

  override def toString = s"${id.componentType}_${id.componentDetails} x${quantity} €${price*quantity}"

