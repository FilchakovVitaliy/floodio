package simulations.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object FloodIoRequests {
  val loadStep2Page_request = http("GetStep2").get("/step/2")
  val loadStep3Page_request = http("GetStep3").get("/step/3")
  val loadStep4Page_request = http("GetStep4").get("/step/4")
  val loadStep5Page_request = http("GetStep5").get("/step/5")
  val loadDonePage_request = http("DonePage").get("/done")
  val ajaxGenerateCode_request = http("generateCode").get("/code")
  //val ageChoice = csv("ageChoice.csv").eager.random
  val customSeparatorFeeder = separatedValues("ageChoice.csv", '\n')
  val loadHomePage_request = http("HomePage")
    .get("/")
  val completeStep1_request = http("CompleteStep1").post("/start")
    .formParam("utf8", "✓")
    .formParam("authenticity_token", "${authenticity_token}").asFormUrlEncoded
    .formParam("challenger[step_id]", "${challenger_step_id}").asFormUrlEncoded
    .formParam("challenger[step_number]", "1")
    .formParam("commit", "Start")
  val completeStep2_request = http("CompleteStep2").post("/start")
    .formParam("utf8", "✓")
    .formParam("authenticity_token", "${authenticity_token}").asFormUrlEncoded
    .formParam("challenger[step_id]", "${challenger_step2_id}").asFormUrlEncoded
    .formParam("challenger[step_number]", "2")
    .formParam("challenger[age]", "28")
    .formParam("commit", "Next")
  val completeStep3_request = http("CompleteStep3").post("/start")
    .formParam("authenticity_token", "${authenticity_token}").asFormUrlEncoded
    .formParam("challenger[step_id]", "${challenger_step3_id}").asFormUrlEncoded
    .formParam("challenger[step_number]", "3")
    .formParam("challenger[largest_order]", "${maxNumber}")
    .formParam("challenger[order_selected]", "${challenger_order_selected}").asFormUrlEncoded
    .formParam("commit", "Next")
  val completeStep4_request = http("CompleteStep4")
    .post("/start")
    .formParam("utf8", "✓")
    .formParam("authenticity_token", "${authenticity_token}").asFormUrlEncoded
    .formParam("challenger[step_id]", "${challenger_step4_id}").asFormUrlEncoded
    .formParam("challenger[step_number]", "4")
    .formParam("${nameChallengerOrder1}", "${order_value}")
    .formParam("${nameChallengerOrder2}", "${order_value}")
    .formParam("${nameChallengerOrder3}", "${order_value}")
    .formParam("${nameChallengerOrder4}", "${order_value}")
    .formParam("${nameChallengerOrder5}", "${order_value}")
    .formParam("${nameChallengerOrder6}", "${order_value}")
    .formParam("${nameChallengerOrder7}", "${order_value}")
    .formParam("${nameChallengerOrder8}", "${order_value}")
    .formParam("${nameChallengerOrder9}", "${order_value}")
    .formParam("${nameChallengerOrder10}", "${order_value}")
    .formParam("commit", "Next")
  val completeStep5_request = http("CompleteStep5").post("/start")
    .formParam("utf8", "✓")
    .formParam("authenticity_token", "${authenticity_token}").asFormUrlEncoded
    .formParam("challenger[step_id]", "${challenger_step5_id}").asFormUrlEncoded
    .formParam("challenger[step_number]", "5")
    .formParam("challenger[one_time_token]", "${oneTimeToken}")
    .formParam("commit", "Next")
}
