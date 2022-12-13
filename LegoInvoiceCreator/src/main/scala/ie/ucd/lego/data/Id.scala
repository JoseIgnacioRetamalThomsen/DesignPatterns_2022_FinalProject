package ie.ucd.lego.data

import ie.ucd.lego.Id

import scala.collection.mutable.ArrayBuffer

case class Id(componentType:String, componentDetails:String):
  override def toString: String = componentType + "_" + componentDetails

object  Id:
  def fromString(stringId: String): Id =
    val idArray = stringId.split("_")
    Id(idArray(0),idArray(1))

//object  ComponentIdPrototype:
//  val ComponentTypes = ArrayBuffer[Component]()
//  def getId: String =
//    componentType.toString + "_" + description.toString
//
//object ComponentType extends Enumeration:
//  typpe = Value
//  val Block,Window,Door = Value
////enum ComponentType:
////  case Block, Window, Door
//
//enum BlockType:
//  case Hollow, Solid
//
//enum DoorType:
//  case Frames4,Frames3
//
//enum WindowType:
//  case WithHandle
