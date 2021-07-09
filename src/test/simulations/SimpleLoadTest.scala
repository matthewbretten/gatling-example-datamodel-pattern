package simulations

import config.Constants
import io.gatling.core.Predef._
import scala.concurrent.duration._

class SimpleLoadTest extends BaseSimulation {
  setUp(
    customCreatesNewBasketScenario.inject(
      constantUsersPerSec(1).during(10 seconds)
    )
  )
    .protocols(Constants.httpProtocol)
    .assertions(global.successfulRequests.percent.is(100))
}