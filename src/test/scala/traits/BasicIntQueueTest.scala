package traits

import org.scalatest.{ShouldMatchers, FunSpec}

class BasicIntQueueTest extends FunSpec with ShouldMatchers {
  describe("A queue") {
    it("should support first in, first out") {
      val queue = new BasicIntQueue
      queue.put(1)
      queue.put(2)

      val result = (queue.get(), queue.get())
      result should equal((1, 2))
    }

    it("should support double") {
      val queue = new BasicIntQueue with Doubling
      queue.put(1)
      queue.put(2)

      val result = (queue.get(), queue.get())
      result should equal((2, 4))
    }

    it("should support filter positive integer") {
      val queue = new BasicIntQueue with Filtering
      queue.put(-1)
      queue.put(2)
      queue.put(4)

      val result = (queue.get(), queue.get())
      result should equal((2, 4))
    }

    it("should support incrementing") {
      val queue = new BasicIntQueue with Incrementing
      queue.put(2)
      queue.put(4)

      val result = (queue.get(), queue.get())
      result should equal((3, 5))
    }

    it("should support stack modification") {
      val queue = new BasicIntQueue with Incrementing with Doubling
      queue.put(2)
      queue.put(4)

      val result = (queue.get(), queue.get())
      result should equal((5, 9))
    }
  }
}
