package highorderfunction

object FiltersV1 {
  type EmailFilter = Email => Boolean

  val sendByOneOf: Set[String] => EmailFilter =
    senders =>
      email => senders.contains(email.sender)

  val notSendByAnyOf: Set[String] => EmailFilter =
    senders =>
      email => !senders.contains(email.sender)

  val minimumSize: Int => EmailFilter =
    n =>
      email => email.text.size >= n

  val maximumSize: Int => EmailFilter =
    n =>
      email => email.text.size <= n
}
