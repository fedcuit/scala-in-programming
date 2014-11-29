package highorderfunction

object FiltersV2 {
  type EmailFilter = Email => Boolean
  type SizeChecker = Int => Boolean

  val sendByOneOf: Set[String] => EmailFilter =
    senders =>
      email => senders.contains(email.sender)

  val notSendByAnyOf: Set[String] => EmailFilter =
    senders =>
      email => !senders.contains(email.sender)

  val minimumSize: Int => EmailFilter =
    n => sizeConstraint(_ >= n)

  val maximumSize: Int => EmailFilter =
    n => sizeConstraint(_ <= n)

  val sizeConstraint: SizeChecker => EmailFilter =
    f =>
      email => f(email.text.size)
}
