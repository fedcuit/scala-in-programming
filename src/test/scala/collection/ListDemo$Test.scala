package collection

import org.scalatest.{ShouldMatchers, FunSpec}

class ListDemo$Test extends FunSpec with ShouldMatchers {
  describe("List") {
    it("should support reverse itself using leftFold") {
      ListDemo.reverseLeft(List(1, 2, 3)) should equal(List(3, 2, 1))
    }

    it("should able to create a multiplication table with tabulate") {
      println(ListDemo.multiTable)
    }

    it("should able to find the longest word") {
      ListDemo.longestWord("The quick brown fox".split(" ")) should equal(("quick",1))
    }
  }
}
