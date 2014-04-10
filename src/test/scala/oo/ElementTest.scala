package oo

import org.scalatest.{FunSpec, ShouldMatchers}
import oo.Element.element

class ElementTest extends FunSpec with ShouldMatchers {
  describe("Array element") {
    it("should support put another element above it") {
      val ele1 = element(Array("hello", "world"))
      val ele2 = element(Array("copy", "that"))

      val ele3 = ele1.above(ele2)

      ele3.toString should be(
        """hello
          |world
          |copy
          |that""".stripMargin)
    }

    it("should support put another element beside it") {
      val ele1 = element(Array("hello", "world"))
      val ele2 = element(Array("copy", "that"))

      val ele3 = ele1.beside(ele2)

      ele3.toString should be(
        """hellocopy
          |worldthat""".stripMargin)
    }
  }

  describe("Line element") {
    it("should support put another element above it") {
      val ele1 = element("hello")
      val ele2 = element("world")

      val ele3 = ele1.above(ele2)

      ele3.toString should be(
        """hello
          |world""".stripMargin)
    }

    it("should support put another element beside it") {
      val ele1 = element("hello")
      val ele2 = element("world")

      val ele3 = ele1.beside(ele2)

      ele3.toString should be("helloworld")
    }
  }

}
