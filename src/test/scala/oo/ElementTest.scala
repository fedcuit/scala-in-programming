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

  describe("Uniform element") {
    it("should be created with given character, width, height") {
      val ele1 = element('t', 5, 4)

      ele1.toString should be(
        """ttttt
          |ttttt
          |ttttt
          |ttttt""".stripMargin)
    }

    it("should support put another element above it") {
      val ele1 = element('h', 2, 8)
      val ele2 = element('w', 4, 2)

      val ele3 = ele1.above(ele2)

      ele3.toString should be(
        """hh
          |hh
          |hh
          |hh
          |hh
          |hh
          |hh
          |hh
          |wwww
          |wwww""".stripMargin)
    }

    it("should support put another element beside it") {
      val ele1 = element('h', 2, 8)
      val ele2 = element('w', 4, 2)

      val ele3 = ele1.beside(ele2)

      ele3.toString should be(
        """hhwwww
          |hhwwww""".stripMargin)
    }
  }

}
