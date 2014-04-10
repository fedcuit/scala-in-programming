package oo

abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length //vertical height

  def width: Int = if (height == 0) 0 else contents(0).length // the width of the first element

  def above(e: Element): Element

  def beside(e: Element): Element
}

object Element {
  def element(contents: Array[String]): Element = {
    new ArrayElement(contents)
  }

  def element(line: String): Element = {
    new LineElement(line)
  }
}
