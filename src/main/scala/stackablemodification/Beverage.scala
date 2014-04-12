package stackablemodification

import pattern.decorator.Coffee

trait Milk extends Coffee {
  abstract override def cost = 1 + super.cost
}

trait Mocha extends Coffee {
  abstract override def cost = 5 + super.cost
}