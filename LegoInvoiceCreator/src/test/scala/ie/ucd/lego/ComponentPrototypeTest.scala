package ie.ucd.lego

import ie.ucd.lego.data.Id
import munit.FunSuite
import prototype.LegoPrototype

class ComponentPrototypeTest extends FunSuite {

  test("that initialize"){
    assertEquals(3,LegoPrototype.parts.size)
    print(LegoPrototype.parts)
  }

  test("that can get component"){
    val component = Id("Block","Solid")
    val blockSolid = LegoPrototype.getComponent(component)
    println(blockSolid)
  }

  test("that can add when key exists"){
    LegoPrototype.addComponent("Block","Medium")
    println(LegoPrototype.parts)
    LegoPrototype.updateComponentPrice("Block","Medium",12.5)
    println(LegoPrototype.parts)
  }
}
