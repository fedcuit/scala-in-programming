package extractor

object GivenNames {
  def unapplySeq(name: String): Option[Seq[String]] = {
    val names: Array[String] = name.trim().split(" ")
    if (names.forall(_.isEmpty)) None else Some(names)
  }
}

object Names {
  def unapplySeq(name: String): Option[(String, String, Seq[String])] = {
    val names = name.trim().split(" ")
    if (names.length < 2) None
    else Some((names.last, names.head, names.drop(1).dropRight(1).toList))
  }
}

object SeqExtractorMain extends App {
  // only extract first name
  val name = "Alejandro Demetrius Nathaniel Sebastian"
  name match {
    case GivenNames(firstName, _*) => println(s"First name is: $firstName")
    case _ => println("at least give me a name")
  }

  // only extract last name and first name, abandon middle name
  val another_name = "Alejandro Demetrius Nathaniel Sebastian"
  another_name match {
    case Names(lastName, firstName, _*) => println(s"$firstName $lastName")
    case _ => println("at least give me a name")
  }
}
