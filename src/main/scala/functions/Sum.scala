package functions

object Sum {
  def square(x: Int) = x * x

  def sumSquare(a: Int, b: Int): Int = if (a > b) 0 else square(a) + sumSquare(a + 1, b)

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sum(f, a + 1, b)
  }

  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      if (a > b) 0 else f(a) + sumF(a + 1, b)
    }
    sumF
  }

  def sum2(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sum2(f)(a + 1, b)
  }

  def sum3(f: Int => Int)(a: Int, b: Int): Int = {
    def iter(a: Int, result: Int): Int = {
      if (a > b) result else iter(a + 1, result + f(a))
    }

    iter(a, 0)
  }
}
