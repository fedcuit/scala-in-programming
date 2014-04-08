class MyAssert(isDebugEnabled: Boolean) {
  def byNameAssert(predicate: => Boolean) {
    if (isDebugEnabled && !predicate) {
      throw new RuntimeException()
    }
  }
}
