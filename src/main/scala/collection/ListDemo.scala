package collection

object ListDemo {
  def multiTable: String = {
    List.tabulate(9, 9)((r, c) => (r + 1) * (c + 1)).map(_.mkString(" ")).mkString("\n")
  }

  def reverseLeft[T](xs: List[T]) = (List[T]() /: xs) { (ys, y) => y :: ys}

  def longestWord(words: Array[String]) = words.toList.zipWithIndex.maxBy(_._1.length)
}
