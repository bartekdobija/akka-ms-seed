package $organization$.actors

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import net.manub.embeddedkafka.EmbeddedKafka

private[actors] abstract class ActorSpec
    extends TestKit(ActorSystem("TestActorSystem"))
    with ImplicitSender
    with WordSpecLike
    with Matchers
    with BeforeAndAfterAll
    with EmbeddedKafka {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

}