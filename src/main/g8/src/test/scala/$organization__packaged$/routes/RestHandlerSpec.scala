package $organization$.routes

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.http.scaladsl.model.ContentTypes
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import $organization$.UnitSpec
import $organization$.actors.HandlerActor
import $organization$.core.Service

class RestHandlerSpec extends UnitSpec with ScalatestRouteTest {

  private var route: Route = _

  override def beforeAll(): Unit = {

    val producer: ActorRef = ActorSystem(Service.DEFAULT_SYSTEM_NAME)
      .actorOf(Props[HandlerActor], HandlerActor.NAME)

    route = RestHandler(producer).route
  }

  "Service()" must {

    "implement httpRoute method" in {
      route shouldBe a[Route]
    }

    "route GET requests" in {
      val valid = "/ping/26696a6e-bb9c-40ee-9841-3bec9bda9dd6"
      Get(valid) ~> route ~> check {
        responseAs[String] shouldEqual "{\"id\":\"pong\",\"pongMsg\":\"message\"}"
        contentType shouldEqual ContentTypes.`application/json`
      }
    }

  }

}
