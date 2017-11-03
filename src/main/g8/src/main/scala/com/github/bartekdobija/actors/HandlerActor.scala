package com.github.bartekdobija.actors

import akka.actor.{Actor, ActorLogging}
import com.github.bartekdobija.actors.HandlerActor.{Ping, Pong}

object HandlerActor {
  case class Ping(id: String, pingMsg: String)
  case class Pong(id: String, pongMsg: String)

  val NAME = "handler"
}

class HandlerActor extends Actor with ActorLogging {

  override def receive: Receive = {
    case Ping(i, s) => sender() ! Pong("pong", "message")
  }
}
