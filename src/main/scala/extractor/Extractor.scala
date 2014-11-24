package extractor

trait User {
  def name: String

  def score: Int
}

class FreeUser(val name: String, val score: Int, val upgradeProbability: Double) extends User

object FreeUser {
  def unapply(user: FreeUser): Option[(String, Int, Double)] = Some((user.name, user.score, user.upgradeProbability))
}

object premiumCandidate {
  def unapply(user: FreeUser): Boolean = user.upgradeProbability > 0.7d
}

class PremiumUser(val name: String, val score: Int) extends User

object PremiumUser {
  def unapply(user: PremiumUser): Option[(String, Int)] = Some((user.name, user.score))
}


object Main extends App {
  val user = new FreeUser("efeng", 100, 0.7d)
  user match {
    case freeUser @ premiumCandidate() => println("this is a potential premium user")
    case FreeUser(name, _, p) => println("Hello " + name)
  }
}
