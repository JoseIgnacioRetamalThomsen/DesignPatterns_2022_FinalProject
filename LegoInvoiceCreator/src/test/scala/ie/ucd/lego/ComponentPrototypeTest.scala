package ie.ucd.lego

import ie.ucd.lego.data.Id
import munit.FunSuite
import prototype.ComponentPrototype

class ComponentPrototypeTest extends FunSuite {

  test("that initialize"){
    assertEquals(3,ComponentPrototype.parts.size)
    print(ComponentPrototype.parts)
  }

  test("that can get component"){
    val component = Id("Block","Solid")
    val blockSolid = ComponentPrototype.getComponent(component)
    println(blockSolid)
  }
}
