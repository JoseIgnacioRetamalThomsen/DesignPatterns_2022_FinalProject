package ie.ucd.lego.prototype

import ie.ucd.lego.*
import ie.ucd.lego.data.*
import ie.ucd.lego.composite.*

import scala.collection.mutable.Map

object LegoPrototype:
  val forkJoinPool = new java.util.concurrent.ForkJoinPool(1)

  val parts: Map[String, Map[String, Lego]] = Map()
  parts += ("Block" -> Map[String, Lego]())
  parts += ("Window" -> Map[String, Lego]())
  parts += ("Door" -> Map[String, Lego]())
  parts("Block") += ("Solid" -> Block())
  parts("Block") += ("Hollow" -> Block(id = Id("Block", "Hollow"),price = 7.5))
  parts("Door") += ("WithHandle" -> Door())
  parts("Window") += ("Frames4" -> Window())
  var room = InvoiceComposite(Id.fromString("Room_Basic"))
  room.addComponent(getComponent(Id.fromString("Block_Solid"),10))
  room.addComponent(getComponent(Id.fromString("Door_WithHandle"),2))
  room.addComponent(getComponent(Id.fromString("Window_Frames4"),3))
  parts += ("Room" -> Map[String,Lego]())
  println("room" +room.components)
  parts("Room") += ("Basic" -> room)
  def getComponent(id: Id): Lego =
    id.componentType match
      case "Block" => parts(id.componentType)(id.componentDetails).asInstanceOf[Block].copy()
      case "Door" => parts(id.componentType)(id.componentDetails).asInstanceOf[Door].copy()
      case "Window" => parts(id.componentType)(id.componentDetails).asInstanceOf[Window].copy()
      case "Room" => parts(id.componentType)(id.componentDetails).asInstanceOf[InvoiceComposite].myCopy()

  def getComponent(id: Id, quantity:Int): Lego =
    id.componentType match
      case "Block" => parts(id.componentType)(id.componentDetails).asInstanceOf[Block].copy(quantity = quantity)
      case "Door" => parts(id.componentType)(id.componentDetails).asInstanceOf[Door].copy(quantity = quantity)
      case "Window" => parts(id.componentType)(id.componentDetails).asInstanceOf[Window].copy(quantity = quantity)
      case "Room" => parts(id.componentType)(id.componentDetails).asInstanceOf[InvoiceComposite].myCopy(quantity = quantity)

  def addComponent(componentType: String, componentDescription: String,componentPrice:Double): Unit =
    forkJoinPool.execute(() => addNewComponent(componentType, componentDescription,componentPrice))

  def addNewComponent(componentType: String, componentDescription: String,componentPrice:Double): Unit =
    componentType match {
      case "Block" => parts("Block") += (componentDescription -> Block(id = Id("Block", componentDescription),price = componentPrice))
      case "Door" => parts("Door") += (componentDescription -> Door(id = Id("Door", componentDescription),price = componentPrice))
      case "Window" => parts("Window") += (componentDescription -> Window(id = Id("Window", componentDescription),price = componentPrice))
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


