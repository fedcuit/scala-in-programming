package pattern.decorator

class Milk(coffee: Coffee) extends Coffee {
  override def cost = coffee.cost + 1
}

class Soy(coffee: Coffee) extends Coffee {
  override def cost: Int = coffee.cost + 2
}

class Mocha(coffee: Coffee) extends Coffee {
  override def cost: Int = coffee.cost + 5
}

class Whip(coffee: Coffee) extends Coffee {
  override def cost: Int = coffee.cost + 6
}