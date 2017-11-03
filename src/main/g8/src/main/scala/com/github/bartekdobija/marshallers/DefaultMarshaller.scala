package com.github.bartekdobija.marshallers

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.github.bartekdobija.actors.HandlerActor.{Ping, Pong}
import spray.json.DefaultJsonProtocol

trait DefaultMarshaller extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val ping = jsonFormat2(Ping)
  implicit val pong = jsonFormat2(Pong)
}
