package ie.ucd.lego


import scala.collection.mutable.ArrayBuffer

enum BlockType:
 case Hollow, Solid

trait Component:
  def price: Double 
  def name: String
  def detail: String
  override def toString = s"${name} $detail €${price}"
    
case class Block(
  name: String = "Block", 
  price: Double = 10.00,
  material: BlockType = BlockType.Solid 
) extends Component:
  def detail = material.toString

case class Door(
  name: String = "Door", 
  price: Double = 12.50,
  handle: Boolean = true
) extends Component:
  def detail = (if handle then "with handle" else "")

case class Window(
  name: String = "Window", 
  price: Double = 17.50,
  noOfFrames: Integer = 4
) extends Component:
  def detail = s"$noOfFrames frames"


class Invoice:
  val components = ArrayBuffer[Component]()
  def addBlock(b: Block) = components += b
  def addWindow(w: Window) = components += w
  def addDoor(d: Door) = components += d
  
  override def toString =
    val totalPrice = components.map(_.price).sum
    val compList = components.foldLeft("")((str, c) => str + c.toString + "\n")
    s"${compList}\nTOTAL PRICE: €${totalPrice}"

class InvoiceCreator:
  val invoice = Invoice()
  invoice.addBlock(Block())
  invoice.addBlock(Block("Block432", 8.34, BlockType.Hollow))
  invoice.addWindow(Window())
  invoice.addDoor(Door())   

@main def main(): Unit =
  val myInvoiceCreator = InvoiceCreator()
  println(myInvoiceCreator.invoice.toString)
