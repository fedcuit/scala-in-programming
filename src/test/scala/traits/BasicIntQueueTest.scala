package traits

import org.scalatest.{ShouldMatchers, FunSpec}

class BasicIntQueueTest extends FunSpec with ShouldMatchers {
  describe("A queue") {
    it("should support first in, first out") {
      val queue = new BasicIntQueue()

      queue.put(1)
      queue.put(2)

      val result = (queue.get(), queue.get())
      result should equal((1, 2))
    }
  }
}
