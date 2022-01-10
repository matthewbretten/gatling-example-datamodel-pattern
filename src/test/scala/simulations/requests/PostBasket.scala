package requests

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object PostBasket {
  val post: ChainBuilder = exec(
    http("Create new basket")
      .post("/new/basket")
      .header("content-type","application/json")
      .body(StringBody("#{basket}")).asJson
      .check(status.is(200))
  )
}