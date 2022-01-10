package config

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

object Constants {
  private var environment = System.getProperty("environment")
  if (environment == null){
    environment = "local"
  }

  private val prodUrl = s"https://example-$environment-environment.com"
  private val localUrl = s"http://localhost:5000"

  private def setUrl: String = if (environment == "local") localUrl else prodUrl

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(setUrl)

}