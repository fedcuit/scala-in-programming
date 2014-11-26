package future

import future.Ingredient._
import future.SlowCoffeeMachine.prepareCappuccino

import scala.util.Try

object SlowCoffeeMachine {

  def grind(beans: CoffeeBeans): GroundCoffee = {
    println("start grinding...")
    Thread.sleep(2000)
    if (beans == "backed beans") throw GrindingException("are you joking?")
    println("finish grinding")
    s"ground coffee of $beans"
  }

  def heatWater(water: Water): Water = {
    println("heating the water now")
    Thread.sleep(2000)
    println("hot, it's hot!")
    water.copy(temperature = 85)
  }

  def frothMilk(milk: Milk): FrothedMilk = {
    println("milk frothing system engaged")
    Thread.sleep(2000)
    println("shutting down milk frothing system")
    s"frothed $milk"
  }

  def brew(coffee: GroundCoffee, heatedWater: Water): Espresso = {
    println("happy brewing :)")
    Thread.sleep(2000)
    println("it's brewed")
    s"espresso"
  }

  def combine(espresso: Espresso, frothedMilk: FrothedMilk): Cappuccino = "Cappuccino"

  def prepareCappuccino(): Try[Cappuccino] = for {
    ground <- Try(grind("arabica beans"))
    water <- Try(heatWater(Water(25)))
    foam <- Try(frothMilk("milk"))
    espresso <- Try(brew(ground, water))
  } yield combine(espresso, foam)
}

object SlowCoffeeMachineMain extends App {
  private val startPoint = System.currentTimeMillis()

  prepareCappuccino()

  private val timeSpent = System.currentTimeMillis() - startPoint
  println(s"It took $timeSpent millisecond to make this cup of coffee")
}
