package promise

import promise.Government.TaxCut

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future, Promise}
import scala.util.{Failure, Success, Try}

object Government {

  case class TaxCut(reducePercentage: Int)

  case class LameExcuse(msg: String) extends Exception(msg)

  def redeemCampaignPledge(): Future[TaxCut] = {
    val promise = Promise[TaxCut]()
    Future {
      println("Starting the new legislative period")
      Thread.sleep(2000)
      //      promise.success(TaxCut(20))
      //      println("We reduced the taxes! You must reelect us!!!")
      promise.failure(LameExcuse("global economy crisis"))
      println("We didn't fulfil our promises, but surely they'll understand.")
    }
    promise.future
  }
}

object GovernmentMain extends App {
  private val taxCutFuture = Government.redeemCampaignPledge()
  println("Now they're elected, let's see if they remember their promises...")

  Try {
    Await.result(taxCutFuture, 10 seconds)
  } match {
    case Success(TaxCut(reduction)) => println(s"What a miracle, they really cut our taxes by $reduction percentage points")
    case Failure(ex) => println(s"They broke their promise. Again! Because of a $ex")
  }
}
