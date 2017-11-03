package com.github.bartekdobija.routes

import akka.actor.ActorRef
import akka.http.scaladsl.server.{Directives, Route}

import scala.concurrent.duration._
import akka.util.Timeout
import akka.pattern.ask
import com.github.bartekdobija.actors.HandlerActor.{Ping, Pong}
import com.github.bartekdobija.marshallers.DefaultMarshaller

object RestHandler {
  def apply(handlerActor: ActorRef): RestHandler = new RestHandler(handlerActor)
}

class RestHandler(private val handlerActor: ActorRef)
    extends Directives
    with DefaultMarshaller {

  implicit val _ = Timeout(1 seconds)

  def route: Route = {
    decodeRequest {
      encodeResponse {
        get {
          pathPrefix("ping" / JavaUUID) { id =>
            onSuccess((handlerActor ? Ping("1", "ping")).mapTo[Pong]) { res =>
              complete(res)
            }
          } ~
            path("monitor") {
              complete(s"monitor: ${System.currentTimeMillis}")
            }
        }
      }
    }
  }

}
