package ie.ucd.lego.prototype

import ie.ucd.lego.*
import ie.ucd.lego.data.*

import scala.collection.mutable.Map

object ComponentPrototype:
  val forkJoinPool = new java.util.concurrent.ForkJoinPool(1)

  val parts: Map[String, Map[String, Lego]] = Map()
  parts += ("Block" -> Map[String, Lego]())
  parts += ("Window" -> Map[String, Lego]())
  parts += ("Door" -> Map[String, Lego]())
  parts("Block") += ("Solid" -> Block())
  parts("Block") += ("Hollow" -> Block(id = Id("Block", "Hollow")))
  parts("Door") += ("WithHandle" -> Door())
  parts("Window") += ("Frames4" -> Window())

  def getComponent(id: Id): Lego =
    id.componentType match
      case "Block" => parts(id.componentType)(id.componentDetails).asInstanceOf[Block].copy()
      case "Door" => parts(id.componentType)(id.componentDetails).asInstanceOf[Door].copy()
      case "Window" => parts(id.componentType)(id.componentDetails).asInstanceOf[Window].copy()

  def getComponent(id: Id, quantity:Int): Lego =
    id.componentType match
      case "Block" => parts(id.componentType)(id.componentDetails).asInstanceOf[Block].copy(quantity = quantity)
      case "Door" => parts(id.componentType)(id.componentDetails).asInstanceOf[Door].copy(quantity = quantity)
      case "Window" => parts(id.componentType)(id.componentDetails).asInstanceOf[Window].copy(quantity = quantity)

  def addComponent(componentType: String, componentDescription: String): Unit =
    forkJoinPool.execute(() => addNewComponent(componentType, componentDescription))

  def addNewComponent(componentType: String, componentDescription: String): Unit =
    componentType match {
      case "Block" => parts("Block") += (componentDescription -> Block(id = Id("Block", componentDescription)))
      case "Door" => parts("Door") += (componentDescription -> Door(id = Id("Door", componentDescription)))
      case "Window" => parts("Window") += (componentDescription -> Window(id = Id("Window", componentDescription)))
      case _ => throw new Exception("Component type not found.")
    }

  def updatePrice(componentType: String, componentDescription: String, newPrice: Double): Unit =
    forkJoinPool.execute(() => updateComponentPrice(componentType, componentDescription, newPrice))

  def updateComponentPrice(componentType: String, componentDescription: String, newPrice: Double): Unit =
    componentType match
      case "Block" => parts(componentType)(componentDescription) =
        parts(componentType)(componentDescription).asInstanceOf[Block].copy(price = newPrice)
      case "Door"
      => parts(componentType)(componentDescription)=
        parts(componentType)(componentDescription).asInstanceOf[Door].copy(price = newPrice)
      case "Window"
      =>parts(componentType)(componentDescription)=
        parts(componentType)(componentDescription).asInstanceOf[Window].copy(price = newPrice)


