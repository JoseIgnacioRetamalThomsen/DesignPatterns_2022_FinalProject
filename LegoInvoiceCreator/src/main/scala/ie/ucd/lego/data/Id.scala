package ie.ucd.lego.data

import ie.ucd.lego.data.Id

import scala.collection.mutable.ArrayBuffer

case class Id(componentType:String, componentDetails:String):
  override def toString: String = componentType + "_" + componentDetails

object  Id:
  def fromString(stringId: String): Id =
    val idArray = stringId.split("_")
    Id(idArray(0),idArray(1))

