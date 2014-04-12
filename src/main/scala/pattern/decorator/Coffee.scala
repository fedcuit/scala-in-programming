package pattern.decorator

abstract class Coffee() {
  def name: String = this.getClass.getName

  def cost: Int
}


class HouseBlend extends Coffee {
  override def cost: Int = 10
}

class DarkRoast extends Coffee {
  override def cost: Int = 20
}

class Decaf extends Coffee {
  override def cost: Int = 15
}

class Espressoextends extends Coffee {
  override def cost: Int = 12
}

