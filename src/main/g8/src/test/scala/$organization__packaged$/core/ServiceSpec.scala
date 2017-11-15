package $organization$.core

import akka.http.scaladsl.testkit.ScalatestRouteTest
import $organization$.UnitSpec

class ServiceSpec extends UnitSpec with ScalatestRouteTest {

  private var service: Service = _

  override def beforeAll(): Unit = {
    service = Service()
  }

  classOf[Service].getSimpleName must {
    "implement start() method" in {
      service.start() should not be null
    }

    "implement stop() method" in {
      service.stop()
    }
  }

}