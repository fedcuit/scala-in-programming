import clazzobject.Rational
import org.scalatest.{ShouldMatchers, FunSpec}
import Rational.rational

class RationalTest extends FunSpec with ShouldMatchers {
  describe("An rational") {

    it("should throw exception when d is zero") {
      intercept[IllegalArgumentException] {
        rational(1, 0)
      }
    }

    it("should normalize") {
      val a = rational(3, 6)

      a should be(rational(1, 2))
    }

    it("should support add another rational") {
      val a = rational(1, 2)
      val b = rational(1, 3)

      a + b should be(rational(5, 6))
    }

    it("should support add another integer") {
      val a = rational(1, 2)

      a + 1 should be(rational(3, 2))
    }

    it("should support multiply another rational") {
      val a = rational(1, 2)
      val b = rational(1, 3)

      a * b should be(rational(1, 6))
    }

    it("should support multiply another integer") {
      val a = rational(1, 2)

      a * 10 should be(rational(5, 1))
    }

    it("should support subtract another rational") {
      val a = rational(1, 3)
      val b = rational(1, 4)

      a - b should be(rational(1, 12))
    }

    it("should support subtract another integer") {
      val a = rational(1, 3)

      a - 1 should be(rational(-2, 3))
    }

    it("should support divide another rational") {
      val a = rational(1, 3)
      val b = rational(1, 4)

      a / b should be(rational(4, 3))
    }

    it("should support divide another integer") {
      val a = rational(1, 3)

      a / 3 should be(rational(1, 9))
    }

    it("should support compare with another rational") {
      rational(1, 3) should be < rational(1, 2)
      rational(1, 4) should be > rational(1, 5)
      rational(1, 4) should be >= rational(1, 5)
      rational(1, 6) should be <= rational(1, 5)
    }

  }
}
