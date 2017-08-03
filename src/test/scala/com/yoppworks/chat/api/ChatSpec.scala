package com.yoppworks.chat.api

import com.yoppworks.chat.domain.{ ChatMessage, ChatMessageConsumer, ChatMessagePublisher }
import org.scalatest.FreeSpec
import org.scalamock.scalatest.MockFactory
import org.scalatest.concurrent.ScalaFutures

import scala.concurrent.Future

class ChatSpec extends FreeSpec with MockFactory with ScalaFutures {

  val producerStub :ChatMessagePublisher = stub[ChatMessagePublisher]
  val consumerStub :ChatMessageConsumer = stub[ChatMessageConsumer]

  "publishOneMessage" - {
    "should call ChatProducer with one message" in {
      val api = new Chat(producerStub, consumerStub)
      val expectedMessage : ChatMessage = ChatMessage("sender", "message", "room")
      (producerStub.one _).when(expectedMessage).returns(Future.successful(expectedMessage))

      val result = api.publishOneMessage(expectedMessage)

      assert(result.futureValue === expectedMessage)
    }
  }
}
