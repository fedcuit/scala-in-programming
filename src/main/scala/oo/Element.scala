package oo

abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length //vertical height

  def width: Int = if (height == 0) 0 else contents(0).length // the width of the first element

  def above(e: Element): Element

  def beside(e: Element): Element
}

object Element {

  private class ArrayElement(override val contents: Array[String]) extends Element {
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

  private class LineElement(s: String) extends ArrayElement(Array(s)) {
    override def height = 1

    override def width = s.length
  }


  def element(contents: Array[String]): Element = {
    new ArrayElement(contents)
  }

  def element(line: String): Element = {
    new LineElement(line)
  }
}
