package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("https://challengers.flood.io")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:70.0) Gecko/20100101 Firefox/70.0")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map("Accept" -> "image/webp,*/*")

	val headers_2 = Map(
		"Origin" -> "https://challengers.flood.io",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_6 = Map(
		"Accept" -> "*/*",
		"X-Requested-With" -> "XMLHttpRequest")



	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/img/header.png")
			.headers(headers_1)))
		.pause(2)
		.exec(http("request_2")
			.post("/start")
			.headers(headers_2)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "K8G4PRXwcYwerrZkkq5KnZkVGih2hBsi0tZCj9IvLMA=")
			.formParam("challenger[step_id]", "WkZSZCtBMk5rUW9jaWRacGtpZzk3UT09LS05SEN1VXpSYndJWTJlV2RYaGk4eExRPT0=--edc0c290c8ec08fc5d80f49cd9717e5d869c63fa")
			.formParam("challenger[step_number]", "1")
			.formParam("commit", "Start"))
		.pause(2)
		.exec(http("request_3")
			.post("/start")
			.headers(headers_2)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "K8G4PRXwcYwerrZkkq5KnZkVGih2hBsi0tZCj9IvLMA=")
			.formParam("challenger[step_id]", "K1NiaHdxTkEyU2N6RkZhakRRZWMwUT09LS1kL2R2aWhlL1RjVm04TldLOGExMFNRPT0=--93f49e8ce4461bbd9220da99f3999403c82bac44")
			.formParam("challenger[step_number]", "2")
			.formParam("challenger[age]", "22")
			.formParam("commit", "Next"))
		.pause(4)
		.exec(http("request_4")
			.post("/start")
			.headers(headers_2)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "K8G4PRXwcYwerrZkkq5KnZkVGih2hBsi0tZCj9IvLMA=")
			.formParam("challenger[step_id]", "Z0d5SEZjY1U3QUEzbVE2V0ttMk9BUT09LS0wcnlxWnR4blNMeTNqZE1aMUR3RktBPT0=--b4a40532e76c264e23a1a67e217dfcdaaeb5f4da")
			.formParam("challenger[step_number]", "3")
			.formParam("challenger[largest_order]", "227")
			.formParam("challenger[order_selected]", "MTFjaDkzc1d2UVhlZnVoRmJxVUhXZz09LS0wNmJTVm5EZDhidTJFQUNQd0RRblZnPT0=--c6d6753552225a63f8963fc8c2058e7f56b87944")
			.formParam("commit", "Next"))
		.pause(2)
		.exec(http("request_5")
			.post("/start")
			.headers(headers_2)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "K8G4PRXwcYwerrZkkq5KnZkVGih2hBsi0tZCj9IvLMA=")
			.formParam("challenger[step_id]", "YzF5V0YrVmM4OHlkaHROT0E3eUNaQT09LS1TVmoya0ZtU0VpUXVpaDFxQ2JNeVd3PT0=--65c01de7b85617e741b521a69112a2047fdf6b00")
			.formParam("challenger[step_number]", "4")
			.formParam("challenger[order_0]", "1575037500")
			.formParam("challenger[order_8]", "1575037500")
			.formParam("challenger[order_10]", "1575037500")
			.formParam("challenger[order_6]", "1575037500")
			.formParam("challenger[order_7]", "1575037500")
			.formParam("challenger[order_6]", "1575037500")
			.formParam("challenger[order_8]", "1575037500")
			.formParam("challenger[order_15]", "1575037500")
			.formParam("challenger[order_10]", "1575037500")
			.formParam("challenger[order_17]", "1575037500")
			.formParam("commit", "Next")
			.resources(http("request_6")
			.get("/code")
			.headers(headers_6)))
		.pause(5)
		.exec(http("request_7")
			.post("/start")
			.headers(headers_2)
			.formParam("utf8", "✓")
			.formParam("authenticity_token", "K8G4PRXwcYwerrZkkq5KnZkVGih2hBsi0tZCj9IvLMA=")
			.formParam("challenger[step_id]", "WWhEMXI4K1pBd1I0TWlOMkJuZkQvUT09LS1HZlhDT3MyTnpueUdIWDhmUU5JNmx3PT0=--569aa2bef27d28c3d8f8bbfdcf6ba119bf989891")
			.formParam("challenger[step_number]", "5")
			.formParam("challenger[one_time_token]", " 2802469144")
			.formParam("commit", "Next"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}