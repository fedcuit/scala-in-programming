package highorderfunction

import highorderfunction.Transformer.{addAdvertisementToFooter, addMissingSubject, checkSpelling, removeInappropriateLanguage}


object FreeMailService extends App {
  val mails =
    Email("I will catch you", "The Tom and Jerry Comedy Show", "Tom", "Jerry") ::
      Email("You're under arrest", "Any last word", "batman", "bad guy") :: Nil

  println(mails.filter(FiltersV0.sendByOneOf(Set("batman"))))
  println(mails.filter(FiltersV0.notSendByAnyOf(Set("batman"))))
  println(mails.filter(FiltersV0.maximumSize(14)))
  println(mails.filter(FiltersV0.minimumSize(16)))

  println("-" * 80)

  println(mails.filter(FiltersV1.sendByOneOf(Set("batman"))))
  println(mails.filter(FiltersV1.notSendByAnyOf(Set("batman"))))
  println(mails.filter(FiltersV1.maximumSize(14)))
  println(mails.filter(FiltersV1.minimumSize(16)))

  println("-" * 80)

  println(mails.filter(FiltersV2.sendByOneOf(Set("batman"))))
  println(mails.filter(FiltersV2.notSendByAnyOf(Set("batman"))))
  println(mails.filter(FiltersV2.maximumSize(14)))
  println(mails.filter(FiltersV2.minimumSize(16)))

  println("-" * 80)

  println(mails.filter(FiltersV3.sendByOneOf(Set("batman"))))
  println(mails.filter(FiltersV3.notSendByAnyOf(Set("batman"))))
  println(mails.filter(FiltersV3.maximumSize(14)))
  println(mails.filter(FiltersV3.minimumSize(16)))

  println("-" * 80)
  val mail = Email("", "your dynamic typing is good", "edfeng", "anyone")
  private val pipeline: (Email) => Email = Function.chain(Seq(
    addMissingSubject,
    checkSpelling,
    removeInappropriateLanguage,
    addAdvertisementToFooter))
  println(pipeline(mail))

  val funcChain = addMissingSubject andThen checkSpelling andThen removeInappropriateLanguage andThen addAdvertisementToFooter
  println(funcChain(mail))
}
