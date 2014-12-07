package highorderfunction

object Transformer {
  val addMissingSubject: Email => Email =
    email => if (email.subject.isEmpty) email.copy(subject = "No subject") else email

  val checkSpelling: Email => Email =
    email => email.copy(text = email.text.replaceAll("your", "you're"))

  val removeInappropriateLanguage: Email => Email =
    email => email.copy(text = email.text.replaceAll("dynamic typing", "**CENSORED**"))

  val addAdvertisementToFooter: Email => Email =
    email => email.copy(text = email.text + "\nThis mail sent via Super Awesome Free Mail")
}

