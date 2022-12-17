package ie.ucd.lego.data

import ie.ucd.lego.data.Lego
import ie.ucd.lego.data.Id
import ie.ucd.lego.decorator.AbstractLegoDecorator

trait Lego:
  def quantity : Int
  def price: Double
  def id: Id

  override def toString = s"${id.componentType}_${id.componentDetails} x${quantity} €${price*quantity}"

case class Block(
                  id : Id = Id("Block","Solid"),
                  quantity: Int = 1,
                  price: Double = 10.00 ,
                ) extends Lego

case class Door(
                 id : Id = Id("Door","Frames4"),
                 price: Double = 12.50,
                 quantity: Int = 1
               ) extends Lego

case class Window(
                   id : Id = Id("Window","WithHandle"),
                   price: Double = 17.50,
                   quantity: Int = 1
                 ) extends Lego





