package extractor


object PatternInAnonymousFunctionMain extends App {
  val wordFrequencies = ("habitual", 6) ::("and", 56) ::("consuetudinary", 2) ::
    ("additionally", 27) ::("homely", 5) ::("society", 13) :: Nil

  // find out the word who's frequency is between 3 and 25
  filterTopWordsWithNormalWay(wordFrequencies)

  // use pattern in anonymous function - use case clause to handle sequence unpacking (get rid of accessing tuple fields in this way)
  filterTopWordsWithPattern(wordFrequencies)


  // use pattern to define Function1
  filterTopWordsWithFunction1(wordFrequencies)

  // use partial function (sub type of Function1[A, B])
  filterTopWordsWithPartialFunction(wordFrequencies)

  // use partial function (the explicit way)
  filterTopWordsWithExplicitPartialFunction(wordFrequencies)

  def filterTopWordsWithNormalWay(frequencies: List[(String, Int)]) {
    println(frequencies.filter(wf => wf._2 > 3 && wf._2 < 25).map(_._1))
  }

  def filterTopWordsWithPattern(frequencies: List[(String, Int)]) {
    println(frequencies.filter { case (_, f) => f > 3 && f < 25} map { case (w, _) => w})
  }

  def filterTopWordsWithFunction1(frequencies: List[(String, Int)]) {
    val predicate: ((String, Int)) => Boolean = {
      case (_, f) => f > 3 && f < 25
    }

    val transform: ((String, Int)) => String = {
      case (w, _) => w
    }

    println(frequencies.filter {
      predicate
    } map {
      transform
    })
  }

  def filterTopWordsWithPartialFunction(frequencies: List[(String, Int)]) {
    println(frequencies.collect { case (w, f) if f > 3 && f < 25 => w})
  }

  def filterTopWordsWithExplicitPartialFunction(frequencies: List[(String, Int)]) = {
    val pf = new PartialFunction[(String, Int), String] {
      override def isDefinedAt(x: (String, Int)): Boolean = x match {
        case (w, f) if f > 3 && f < 25 => true
        case _ => false
      }

      override def apply(v1: (String, Int)): String = v1 match {
        case (w, f) if isDefinedAt(v1) => w
      }
    }

    println(frequencies.collect(pf))
  }
}
