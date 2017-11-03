package com.github.bartekdobija.core

import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.{Http, HttpExt}
import akka.stream.ActorMaterializer
import com.github.bartekdobija.actors.HandlerActor
import com.github.bartekdobija.routes.RestHandler

import scala.concurrent.Await
import scala.concurrent.duration._

object Service {

  final val DEFAULT_NIC = "0.0.0.0"
  final val DEFAULT_PORT = 8080
  final val DEFAULT_SYSTEM_NAME = "service"

  def apply(): Service = new Service()
}

class Service {

  private var http: HttpExt = _

  def start(): HttpExt = {
    implicit val system: ActorSystem = ActorSystem(Service.DEFAULT_SYSTEM_NAME)
    implicit val materializer: ActorMaterializer = ActorMaterializer()

    val actor = system.actorOf(Props[HandlerActor], HandlerActor.NAME)
    val handler = RestHandler(actor).route

    http = Http()
    http.bindAndHandle(handler, Service.DEFAULT_NIC, Service.DEFAULT_PORT)
    http
  }

  def stop(): Unit = {
    Await.ready(http.shutdownAllConnectionPools(), 15 seconds)
  }

}
