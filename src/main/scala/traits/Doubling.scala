package traits

trait Doubling extends IntQueue {
  abstract override def put(x: Int) {
    super.put(x * 2)
  }
}
