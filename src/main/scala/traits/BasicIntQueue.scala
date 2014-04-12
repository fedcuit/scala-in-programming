package traits

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private var queue = new ArrayBuffer[Int]

  override def put(x: Int): Unit = queue += x

  override def get(): Int = queue.remove(0)
}
