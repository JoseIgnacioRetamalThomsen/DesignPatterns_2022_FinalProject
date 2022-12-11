package ie.ucd.lego

trait Component:
  def price: Double
//
//  def name: Stromg
//
//  def details : String

  def id: Id

  override def toString = s"${id.componentType} ${id.componentDetails} €${price}"


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

