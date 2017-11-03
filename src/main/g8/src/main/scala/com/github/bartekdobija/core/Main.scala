package com.github.bartekdobija.core

object Main {

  private val service = Service()

  def main(args: Array[String]): Unit = {
    service.start()
    val mainThread = Thread.currentThread
    sys.addShutdownHook({
      service.stop()
      mainThread.join()
    })
  }

}
