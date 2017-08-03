package com.yoppworks.chat.domain

import akka.kafka.scaladsl.Consumer
import akka.stream.scaladsl.Source

import scala.concurrent.Future


trait ChatMessagePublisher {
  def one(chatMessage: ChatMessage) : Future[ChatMessage]
}

trait ChatMessageConsumer {
  def get(topic: String, client: String): Source[ChatMessage,Consumer.Control]
}