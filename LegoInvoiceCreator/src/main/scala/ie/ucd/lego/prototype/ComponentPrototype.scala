package ie.ucd.lego.prototype

import ie.ucd.lego.*
import ie.ucd.lego.data.{Block, Component, Door, Id, Window}

import scala.collection.mutable.Map

object ComponentPrototype:
  val parts: Map[String, Map[String, Component]] = Map()
  parts += ("Block" -> Map[String,Component]())
  parts += ("Window" -> Map[String,Component]())
  parts += ("Door" -> Map[String,Component]())
  parts("Block") += ("Solid" -> Block())
  parts("Block") += ("Hollow" -> Block(id = Id("Block","Hollow")))
  parts("Door") += ("WithHandle" -> Door())
  parts("Window") += ("Frames4" -> Window())

  def getComponent(id: Id) : Component =
    id.componentType match
      case "Block" => parts(id.componentType)(id.componentDetails).asInstanceOf[Block].copy()
      case "Door" => parts(id.componentType)(id.componentDetails).asInstanceOf[Door].copy()
      case "Window" => parts(id.componentType)(id.componentDetails).asInstanceOf[Window].copy()



