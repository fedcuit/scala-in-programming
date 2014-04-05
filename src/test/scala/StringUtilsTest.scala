import org.scalatest.{ShouldMatchers, FunSpec}

class StringUtilsTest extends FunSpec with ShouldMatchers {

  describe("StringUtils") {
    it("should return the same string given the it's length is same as expected length") {
      val s: String = StringUtils.paddingRight("word", 4)

      s should have length 4
    }

    it("should return a string of the expected length given it's length is less than expected length") {
      val s: String = StringUtils.paddingRight("word", 10)

      s should have length 10
      s should endWith("word")
    }

    it("should return the same string given it's length is more than expected length") {
      val s: String = StringUtils.paddingRight("hello world", 5)

      s should have length 11
      s should be("hello world")
    }
  }
}
