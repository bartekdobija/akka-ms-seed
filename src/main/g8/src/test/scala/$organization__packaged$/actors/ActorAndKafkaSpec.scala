package $organization$.actors

import net.manub.embeddedkafka.EmbeddedKafka

private[actors] abstract class ActorAndKafkaSpec
  extends ActorSpec with EmbeddedKafka {

  val bootstrap = "localhost:6001"

  override def beforeAll(): Unit = {
    EmbeddedKafka.start
    super.beforeAll
  }

  override def afterAll: Unit = {
    EmbeddedKafka.stop
    super.afterAll
  }

}