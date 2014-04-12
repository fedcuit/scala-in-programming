package stackablemodification

import org.scalatest.{ShouldMatchers, FunSpec}
import pattern.decorator.DarkRoast

class CoffeeTest extends FunSpec with ShouldMatchers {
  describe("Coffee") {
    it("should cost 20 given no beverage") {
      val coffee = new DarkRoast

      coffee.cost should be (20)
    }

    it("should cost 26 given with milk and mocha") {
      val coffee = new DarkRoast with Milk with Mocha

      coffee.cost should be (26)
    }

  }
}
