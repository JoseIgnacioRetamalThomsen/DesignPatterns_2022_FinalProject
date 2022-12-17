package ie.ucd.lego.service

import ie.ucd.lego.data.Id

object PricesServices:
  val mapPrice = Map("Block_Solid" -> 15.0)

  def getUpdatedPrice(id: Id, actualPrice: Double): Double =
    if mapPrice.contains(id.toString)
    then mapPrice(id.toString)
    else actualPrice
