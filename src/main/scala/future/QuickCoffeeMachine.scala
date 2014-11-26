package future

import future.Ingredient._
import future.QuickCoffeeMachine.prepareCappuccino

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object QuickCoffeeMachine {

  def grind(beans: CoffeeBeans): Future[GroundCoffee] = Future {
    println("start grinding...")
    Thread.sleep(2000)
    if (beans == "backed beans") throw GrindingException("are you joking?")
    println("finish grinding")
    s"ground coffee of $beans"
  }

  def heatWater(water: Water): Future[Water] = Future {
    println("heating the water now")
    Thread.sleep(2000)
    println("hot, it's hot!")
    water.copy(temperature = 85)
  }

  def frothMilk(milk: Milk): Future[FrothedMilk] = Future {
    println("milk frothing system engaged")
    Thread.sleep(2000)
    println("shutting down milk frothing system")
    s"frothed $milk"
  }

  def brew(coffee: GroundCoffee, heatedWater: Water): Future[Espresso] = Future {
    println("happy brewing :)")
    Thread.sleep(2000)
    println("it's brewed")
    s"espresso"
  }

  def combine(espresso: Espresso, frothedMilk: FrothedMilk): Cappuccino = {
    "Cappuccino"
  }

  def prepareCappuccino(): Future[Cappuccino] = {
    val startPoint = System.currentTimeMillis()

    val groundCoffee = grind("arabica beans")
    val hotWater = heatWater(Water(25))
    val frothedMilk = frothMilk("milk")

    for {
      ground <- groundCoffee
      water <- hotWater
      foam <- frothedMilk
      espresso <- brew(ground, water)
    } yield {
      val timeSpent = System.currentTimeMillis() - startPoint
      println(s"It took $timeSpent millisecond to make this cup of coffee")

      combine(espresso, foam)
    }
  }
}

object QuickCoffeeMachineMain extends App {
  prepareCappuccino().map(cappuccino => println("Your coffee, Sir"))

  Thread.sleep(5000)
}
