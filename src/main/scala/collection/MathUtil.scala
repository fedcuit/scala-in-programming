package collection

object MathUtil {

  def makeRow(i: Int): String = {
    val rowSeq = for (j <- 1 to 10) yield StringUtils.paddingRight((i * j).toString, 4)
    rowSeq.mkString
  }

  def multiTable(): String = {
    val table = for (i <- 1 to 10) yield makeRow(i)
    table.mkString("\n")
  }

}
