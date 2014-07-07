object Demo extends App {

  def map(ints: List[Int], function: Int => String): List[String] = {
    ints match {
      case Nil => Nil
      case head :: tail => function(head) :: map(tail, function)
    }
  }

  override def main(args: Array[String]) {
    val myList = List(1, 2, 3, 4)
    val afterMap = map(myList, x => x.toString)
    println(afterMap)
    println(myList.reduceLeft(_ + _))

    val lines = List("line1", "line2 is the largest", "line3")
    println(lines.maxBy(_.length))

    val afterReduce = lines.reduceLeft((r: String, x: String) => if (r.length < x.length) x else r)
    println(afterReduce)
  }
}
