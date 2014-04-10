package oo

import org.scalatest.{FunSpec, ShouldMatchers}

class ArrayElementTest extends FunSpec with ShouldMatchers {
  describe("Array element") {
    it("should support put another element above it") {
      val ele1 = new ArrayElement(Array("hello", "world"))
      val ele2 = new ArrayElement(Array("copy", "that"))

      val ele3 = ele1.above(ele2)

      ele3.toString should be(
        """hello
          |world
          |copy
          |that""".stripMargin)
    }

    it("should support put another element beside it") {
      val ele1 = new ArrayElement(Array("hello", "world"))
      val ele2 = new ArrayElement(Array("copy", "that"))

      val ele3 = ele1.beside(ele2)

      ele3.toString should be(
        """hellocopy
          |worldthat""".stripMargin)
    }
  }

}
