package highorderfunction

class FileMatcher(fileList: Array[String]) {
  def filesRegex(s: String): Array[String] = filesMatching(_.matches(s))

  def filesContaining(s: String): Array[String] = filesMatching(_.contains(s))

  def filesEnding(s: String): Array[String] = filesMatching(_.endsWith(s))

  private def filesMatching(matcher: String => Boolean): Array[String] = for (file <- fileList if matcher(file)) yield file
}
