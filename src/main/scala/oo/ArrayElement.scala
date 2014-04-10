package oo

class ArrayElement(override val contents: Array[String]) extends Element {
  override def beside(e: Element): Element = {
    new ArrayElement(
      for (
        (line1, line2) <- contents zip e.contents
      ) yield line1 + line2
    )
  }

  override def above(e: Element): Element = new ArrayElement(this.contents ++ e.contents)

  override def toString = {
    contents mkString "\n"
  }
}
