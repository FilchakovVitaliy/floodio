package simulations.scenarios

import java.io.FileInputStream
import java.util.Properties

import io.gatling.core.Predef._
import simulations.requests.FloodIoExec._

import scala.io.Source

object floodioscenarios {
//  val pauseProp = new Properties()
//  val source = getClass.getResource("/pause.properties").getPath
//  println(source)
//  pauseProp.load(new FileInputStream(source))
//  pauseProp.getProperty("minDuration")
//  pauseProp.getProperty("maxDuration")
  val minPause = 1
  val maxPause = 5
  val duration=java.lang.Long.getLong("duration", 60)
  val floodIoScenario = scenario("FLOOD").during(duration) {
        exec(loadHomePage).pause(minPause, maxPause)
      .exec(completeStep1).pause(minPause, maxPause)
      .exec(loadStep2Page).pause(minPause, maxPause)
      .exec(completeStep2).pause(minPause, maxPause)
      .exec(loadStep3Page).pause(minPause, maxPause)
      .exec(findMaxNumber).pause(minPause, maxPause)
      .exec(completeStep3).pause(minPause, maxPause)
      .exec(loadStep4Page).pause(minPause, maxPause)
      .exec(getNamesChallengerOrders)
      .exec(completeStep4).pause(minPause, maxPause)
      .exec(ajaxGenerateOneTimeToken)
      .exec(loadStep5Page).pause(minPause, maxPause)
      .exec(completeStep5).pause(minPause, maxPause)
      .exec(loadDonePage).pause(minPause, maxPause)
  }
}
