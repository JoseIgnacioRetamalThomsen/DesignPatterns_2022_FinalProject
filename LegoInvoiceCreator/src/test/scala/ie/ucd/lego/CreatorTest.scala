package ie.ucd.lego

import munit.FunSuite

class CreatorTest extends FunSuite {

  test("that initialize"){
    assertEquals(3,Creator.parts.size)
    print(Creator.parts)
  }

  test("that can get component"){
    val component = Id("Block","Solid")
    val blockSolid = Creator.getComponent(component)
    println(blockSolid)
  }
}
