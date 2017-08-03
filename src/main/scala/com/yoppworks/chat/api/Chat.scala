package com.yoppworks.chat.api

import akka.stream.scaladsl.Source
import com.yoppworks.chat.domain.{ ChatMessage, ChatMessageConsumer, ChatMessagePublisher }

import scala.concurrent.Future


class Chat(publish: ChatMessagePublisher, consumer: ChatMessageConsumer) {
  def publishOneMessage(message: ChatMessage) : Future[ChatMessage] = publish.one(message)
  def getMessages(group: String, client: String) : Source[ChatMessage, Any ]= consumer.get(group, client)

}
