package ie.ucd.lego.data

import ie.ucd.lego.Component
import ie.ucd.lego.data.Id

trait Component:
  def price: Double
  def id: Id

  override def toString = s"${id.componentType}_${id.componentDetails} €${price}"

case class Block(
                  id : Id = Id("Block","Solid"),
                  price: Double = 10.00,
                ) extends Component

case class Door(
                 id : Id = Id("Door","Frames4"),
                 price: Double = 12.50,
               ) extends Component

case class Window(
                   id : Id = Id("Window","WithHandle"),
                   price: Double = 17.50,
                 ) extends Component
