package sort

import org.scalatest.{FunSpecLike, Matchers}

class CollectionUtils$Test extends Matchers with FunSpecLike {
  describe("CollectionUtils") {
    it("should able to sort a list") {
      CollectionUtils.sort(Array(2, 3, 7, 1)) should be(Array(1, 2, 3, 7))
    }
  }
}
