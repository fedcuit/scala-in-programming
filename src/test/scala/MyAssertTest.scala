import org.scalatest.{ShouldMatchers, FunSpec}

class MyAssertTest extends FunSpec with ShouldMatchers {
  private val assert = new MyAssert(true)

  describe("MyAssert") {
    it("should do nothing when predicate is satisfied") {
      assert.byNameAssert(5 > 3)
    }

    it("should throw exception when predicate is not satisfied and debug is enabled") {
      intercept[RuntimeException] {
        assert.byNameAssert(3 > 5)
      }
    }

    it("should do nothing when predicate is not satisfied and debug is disabled") {
      val myAssert = new MyAssert(false)
      myAssert.byNameAssert(3 > 5)
    }

    it("should not have side effect when predicate is not satisfied and debug is disabled") {
      val myAssert = new MyAssert(false)
      myAssert.byNameAssert(3 / 0 == 0)
    }
  }
}
