package simulations

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import feeders.CustomFeeder
import requests.PostBasket

trait BaseSimulation extends Simulation {
  private val basket = CustomFeeder.basket()

  val customCreatesNewBasketScenario: ScenarioBuilder = scenario("Customer creates new basket")
    .feed(basket)
    .exec(PostBasket.post)
}