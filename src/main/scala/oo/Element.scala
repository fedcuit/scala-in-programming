package oo

abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length //vertical height

  def width: Int = if (height == 0) 0 else contents(0).length // the width of the first element

  def above(e: Element): Element = {
    Element.element(this.contents ++ e.contents)
  }

  def beside(e: Element): Element = {
    Element.element(
      for (
        (line1, line2) <- contents zip e.contents
      ) yield line1 + line2
    )
  }

  override def toString = {
    contents mkString "\n"
  }
}

object Element {

  private class ArrayElement(override val contents: Array[String]) extends Element {}

  private class LineElement(s: String) extends ArrayElement(Array(s)) {}

  private class UniformElement(chr: Char, width: Int, height: Int) extends Element {
    override val contents = Array.fill(height)(chr.toString * width)
  }

  def element(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)

  def element(contents: Array[String]): Element = {
    new ArrayElement(contents)
  }

  def element(line: String): Element = {
    new LineElement(line)
  }
}
