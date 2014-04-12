package pattern.decorator

import org.scalatest.{ShouldMatchers, FunSpec}

class CoffeeTest extends FunSpec with ShouldMatchers {
  describe("Coffee") {
    it("should cost 20 given no beverage") {
      val coffee = new DarkRoast

      coffee.cost should be (20)
    }

    it("should cost 26 given with milk and mocha") {
      val coffee = new Mocha(new Milk(new DarkRoast))

      coffee.cost should be (26)
    }
  }
}
