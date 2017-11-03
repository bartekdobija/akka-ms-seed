package com.github.bartekdobija.core

import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.github.bartekdobija.UnitSpec

class ServiceSpec extends UnitSpec with ScalatestRouteTest {

  private var service: Service = _

  override def beforeAll(): Unit = {
    service = Service()
  }

  "Service()" must {
    "implement start() method" in {
      service.start() should not be null
    }

    "implement stop() method" in {
      service.stop()
    }
  }

}