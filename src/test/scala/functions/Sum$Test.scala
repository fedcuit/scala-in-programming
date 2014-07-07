package functions

import functions.Sum._
import org.scalatest.{FunSpec, Matchers}

class Sum$Test extends FunSpec with Matchers {
  describe("Sum") {
    it("should able to calculate square of a number") {
      square(6) should be(36)
    }

    it("should able to calculate sum of squares from 2 to 5") {
      sumSquare(2, 5) should be(54)
    }

    it("should able to calculate sum of squares from 2 to 5 by passing function") {
      sum(square, 2, 5) should be(54)
    }

    it("should able to calculate sum of squares from 2 to 5 using currying functions") {
      sum(square)(2, 5) should be(54)
    }

    it("should able to calculate sum of squares form 2 to 5 using anonymous function") {
      sum(x => x * x)(2, 5) should be(54)
    }

    it("should able to calculate sum of squares from 2 to 5 using currying special syntax") {
      sum2(x => x * x)(2, 5) should be(54)
    }

    it("should able to calculate sum of squares from 2 to 5 using tailing recursion") {
      sum3(x => x * x)(2, 5) should be(54)
    }
  }

}
