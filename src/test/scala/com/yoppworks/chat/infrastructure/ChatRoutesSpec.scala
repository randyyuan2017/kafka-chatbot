package com.yoppworks.chat.infrastructure

import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.yoppworks.chat.api.Chat
import org.scalamock.scalatest.MockFactory
import org.scalatest.{ FreeSpec, Matchers }


class ChatRoutesSpec extends FreeSpec with Matchers with ScalatestRouteTest with ChatRoutes with MockFactory {

  val api: Chat = stub[Chat]



}
