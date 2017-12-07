package $organization$.actors

import akka.actor.{Actor, ActorLogging, Props}
import $organization$.actors.HandlerActor.{Ping, Pong}

object HandlerActor {
  val NAME = getClass.getSimpleName

  case class Ping(id: String, pingMsg: String)
  case class Pong(id: String, pongMsg: String)

  def props(): Props = Props(new HandlerActor)
}

class HandlerActor extends Actor with ActorLogging {

  override def preStart(): Unit = {

  }

  override def receive: Receive = {
    case Ping(i, s) => sender() ! Pong("pong", "message")
    case _ => log.error("received unknown message")
  }
}
