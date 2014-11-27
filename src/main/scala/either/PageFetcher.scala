package either

import scala.io.Source

object PageFetcher {
  def getContent(url: String): Either[String, Source] = {
    if (url.contains("google"))
      Left("this website is blocked for the good of people")
    else Right(Source.fromURL(url))
  }
}

object PageFetcherMain extends App {
  PageFetcher.getContent("http://www.google.com") match {
    case Left(errorMsg) => println(errorMsg)
    case Right(source) => source.getLines().foreach(println)
  }
}
