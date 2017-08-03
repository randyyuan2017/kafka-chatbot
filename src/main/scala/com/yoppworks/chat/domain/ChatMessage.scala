package com.yoppworks.chat.domain


import spray.json.{ DefaultJsonProtocol, _ }

object ChatJsonProtocol extends DefaultJsonProtocol {
  implicit val chatMessageFormat = jsonFormat3(ChatMessage.apply)
}

object ChatMessage {
  import ChatJsonProtocol._
  def apply(jsonString: String): ChatMessage = jsonString.parseJson.convertTo[ChatMessage]
}


case class ChatMessage(sender: String, message: String, room: String) {
  import ChatJsonProtocol._

  def asJsonString = this.toJson.toString()

}
