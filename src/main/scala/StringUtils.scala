object StringUtils {
  def paddingRight(s: String, i: Int): String = {
    val padding = i - s.length
    if (padding <= 0) s else " " * padding + s
  }
}
