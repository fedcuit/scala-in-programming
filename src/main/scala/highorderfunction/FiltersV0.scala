package highorderfunction

object FiltersV0 {
  type EmailFilter = Email => Boolean

  def sendByOneOf(senders: Set[String]): EmailFilter = email => senders.contains(email.sender)

  def notSendByAnyOf(senders: Set[String]): EmailFilter = email => !senders.contains(email.sender)

  def minimumSize(n: Int): EmailFilter = email => email.text.size >= n

  def maximumSize(n: Int): EmailFilter = email => email.text.size <= n
}
