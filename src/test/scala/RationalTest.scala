import org.scalatest.{ShouldMatchers, FunSpec}

class RationalTest extends FunSpec with ShouldMatchers {
  describe("An rational") {
    it("should normalize") {
      val a = new Rational(3, 6)

      a should be(new Rational(1, 2))
    }

    it("should support add another rational") {
      val a = new Rational(1, 2)
      val b = new Rational(1, 3)

      a + b should be(new Rational(5, 6))
    }

    it("should support add another integer") {
      val a = new Rational(1, 2)

      a + 1 should be(new Rational(3, 2))
    }

    it("should support multiply another rational") {
      val a = new Rational(1, 2)
      val b = new Rational(1, 3)

      a * b should be(new Rational(1, 6))
    }

    it("should support multiply another integer") {
      val a = new Rational(1, 2)

      a * 10 should be(new Rational(5, 1))
    }

    it("should support subtract another rational") {
      val a = new Rational(1, 3)
      val b = new Rational(1, 4)

      a - b should be(new Rational(1, 12))
    }

    it("should support subtract another integer") {
      val a = new Rational(1, 3)

      a - 1 should be(new Rational(-2, 3))
    }

    it("should support divide another rational") {
      val a = new Rational(1, 3)
      val b = new Rational(1, 4)

      a / b should be(new Rational(4, 3))
    }

    it("should support divide another integer") {
      val a = new Rational(1, 3)

      a / 3 should be(new Rational(1, 9))
    }

  }
}
