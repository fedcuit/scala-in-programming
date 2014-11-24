package extractor

case class Player(name: String, score: Int)

object PatternEverywhereMain extends App {
  private val player = Player("edfeng", 100)

  printMessage(player)

  // use pattern in pattern matching expression
  def printMessage(player: Player) = player match {
    case Player(_, score) if score > 90 => println("Well done")
    case Player(name, _) => println(s"Hey $name, nice to see you again")
  }

  // use pattern in value definition
  private val Player(name, score) = player

  println(s"name is $name, score is $score")

  // use pattern in sequence unpacking

  private val aTuple: (String, Int) = ("erdong", 120)
  private val (name_a, score_a) = aTuple

  println(s"name is $name_a, score is $score_a")
  println(s"name is ${aTuple._1}, score is ${aTuple._2}")

  // use pattern in for comprehension

  private val gameResults = ("edfeng", 3000) ::("xiaoming", 1000) ::("zhangsan", 2000) :: Nil

  println((for (result <- gameResults if result._2 > 2000) yield {
    result._1
  }).mkString(" "))

  println((for (result <- gameResults; (name, score) = result if score > 2000) yield {
    name
  }).mkString(" "))

  println((for ((name, score) <- gameResults if score > 2000) yield {
    name
  }).mkString(" "))

  // use pattern in for comprehension (filtering can be used when match pattern)

  private val lists = List(1, 2, 3) :: List.empty :: List(5, 3) :: List(4, 5, 6, 0) :: Nil
  println(for (list@first :: 3 :: _ <- lists) yield {
    list
  })
}
