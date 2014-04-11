package oo

import oo.Element.element

/*
object Spiral {
  val space = element(" ")
  val corner = element("+")

  def spiral(nEdges: Int, direction: Int): elementent = {
    if (nEdges == 1)
      element("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4) def verticalBar = element('|', 1, sp.height)
      def horizontalBar = element('-', sp.width, 1)
      if (direction == 0)
        (corner beside horizontalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above (horizontalBar beside corner)
      else
        (verticalBar above corner) beside (space above sp)
    }
  }

  def main(args: Array[String]) {
    val nSides = args(0).toInt
    println(spiral(nSides, 0))
  }
}
*/
