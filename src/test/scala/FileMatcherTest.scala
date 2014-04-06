import org.scalatest.{BeforeAndAfter, ShouldMatchers, FunSpec}

class FileMatcherTest extends FunSpec with ShouldMatchers with BeforeAndAfter {
  val array = Array("hello.scala", "what.cpp", "this.java")
  val matcher = new FileMatcher(array)

  describe("FileMatcher") {
    it("should support search by suffix") {
      val result = matcher.filesEnding(".scala")

      result should have length 1
      result(0) should be("hello.scala")
    }

    it("should support search by substring") {
      val result = matcher.filesContaining("what")

      result should have length 1
      result(0) should be("what.cpp")
    }

    it("should support search by regex") {
      val result = matcher.filesRegex("\\w{4}\\..*")

      result should have length 2
      result should contain("what.cpp")
      result should contain("this.java")
    }
  }

}
