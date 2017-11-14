package $organization$.marshallers

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol
import $organization$.actors.HandlerActor.{Ping, Pong}

trait DefaultMarshaller extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val ping = jsonFormat2(Ping)
  implicit val pong = jsonFormat2(Pong)
}
