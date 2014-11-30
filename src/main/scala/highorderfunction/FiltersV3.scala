package highorderfunction

object FiltersV3 {
  type EmailFilter = Email => Boolean
  type SizeChecker = Int => Boolean

  def complement[A](predicate: A => Boolean): A => Boolean = {
    a => !predicate(a)
  }

  val sendByOneOf: Set[String] => EmailFilter =
    senders =>
      email => senders.contains(email.sender)

  val notSendByAnyOf: Set[String] => EmailFilter =
    sendByOneOf andThen complement

  val sizeConstraint: SizeChecker => EmailFilter =
    f =>
      email => f(email.text.size)

  val minimumSize: Int => EmailFilter =
    n => sizeConstraint(_ >= n)

  val maximumSize: Int => EmailFilter =
    minimumSize andThen complement

}
