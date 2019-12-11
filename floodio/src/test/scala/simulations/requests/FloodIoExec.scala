package simulations.requests
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import simulations.requests.FloodIoRequests._
object FloodIoExec {
  val loadHomePage = exec(loadHomePage_request
    .check(regex("name=\"authenticity_token\".+?value=\"(.+?)\"").saveAs("authenticity_token"))
    .check(regex("name=\"challenger\\[step_id]\\\".+value=\"(.+?)\"").saveAs("challenger_step_id")))
  val loadStep2Page = exec(loadStep2Page_request
    .check(regex("id=\"challenger_step_id\".+value=\"(.+?)\"").saveAs("challenger_step2_id"))
  )
  val loadStep3Page = exec(loadStep3Page_request
    .check(regex("id=\"challenger_step_id\".+value=\"(.+?)\"").saveAs("challenger_step3_id"))
    .check(regex("<label .+?>(.+?)<\\/label>")
      .findAll
      .saveAs("found_numbers"))
    .check(regex("name=\"challenger\\[order_selected\\].+?value=\"(.+?)\".+?>").findAll.saveAs("challenger_orders")))
  val loadStep4Page = exec(loadStep4Page_request
    .check(regex("id=\"challenger_step_id\".+value=\"(.+?)\"").saveAs("challenger_step4_id"))
    .check(regex("d=\"challenger_order_[^abc]?\".+value=\"(.+?)\"").saveAs("order_value"))
    .check(regex("name=\"(challenger\\[order_.+?\\])\"").findAll.saveAs("nameChallengerOrder")))
  val getNamesChallengerOrders = exec(session => {
    val challengerOrders = session("nameChallengerOrder").as[List[String]]
    session
      .set("nameChallengerOrder1", challengerOrders.head)
      .set("nameChallengerOrder2", challengerOrders(1))
      .set("nameChallengerOrder3", challengerOrders(2))
      .set("nameChallengerOrder4", challengerOrders(3))
      .set("nameChallengerOrder5", challengerOrders(4))
      .set("nameChallengerOrder6", challengerOrders(5))
      .set("nameChallengerOrder7", challengerOrders(6))
      .set("nameChallengerOrder8", challengerOrders(7))
      .set("nameChallengerOrder9", challengerOrders(8))
      .set("nameChallengerOrder10", challengerOrders(9))
  })
  val loadStep5Page = exec(loadStep5Page_request
    .check(regex("id=\"challenger_step_id\".+value=\"(.+?)\"").saveAs("challenger_step5_id")))
  val findMaxNumber = exec(sessionFunction = session => {
    val ListNumbers = session("found_numbers").as[List[String]]
    val ListChallengerOrders = session("challenger_orders").as[List[String]]
    val orders = (ListNumbers zip ListChallengerOrders).toMap
    val maxNumber = ListNumbers.map(_.toInt).max
    val challenger_order_selected = orders(maxNumber.toString)
    session
      .set("maxNumber", maxNumber)
      .set("challenger_order_selected", challenger_order_selected)
  })
  val ajaxGenerateOneTimeToken = exec(ajaxGenerateCode_request
    .check(jsonPath("$.code").saveAs("oneTimeToken")))
  val loadDonePage = exec(loadDonePage_request
    .check(status.is(200)))
  val completeStep1 = exec(completeStep1_request
    .check(status.is(302)))
  val completeStep2 = /*feed(ageChoice).*/exec(completeStep2_request
    .check(status.is(302)))
  val completeStep3 = exec(completeStep3_request
    .check(status.is(302)))
  val completeStep4 = exec(completeStep4_request
    .check(status.is(302)))
  val completeStep5 = exec(completeStep5_request
    .check(status.is(302)))
}
