package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import simulations.scenarios.floodioscenarios._

class FloodioSimulation extends Simulation {
  val httpProtocol = http
    .disableFollowRedirect
    .baseUrl("https://training.flooded.io")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:70.0) Gecko/20100101 Firefox/70.0 I AM ROBOT")
  val nbUsers = Integer.getInteger("users", 1)
  val myRamp = java.lang.Long.getLong("ramp", 1)


  setUp(floodIoScenario.inject(rampUsers(nbUsers).during(myRamp)).protocols(httpProtocol))
}

