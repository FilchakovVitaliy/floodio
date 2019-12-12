package simulations.scenarios

import java.io.FileInputStream
import java.util.Properties

import io.gatling.core.Predef._
import simulations.requests.FloodIoExec._

object floodioscenarios {
  val pauseProp = new Properties()
  val rootPath: String = Thread.currentThread.getClass.getResource("").getPath
  pauseProp.load(new FileInputStream(rootPath+"/src/test/resources/pause.properties"))
  val minPause = pauseProp.getProperty("minDuration")
  val maxPause = pauseProp.getProperty("maxDuration")
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
