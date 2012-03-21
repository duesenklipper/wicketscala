package de.wicketbuch.wicketscala2

import org.mortbay.jetty.Connector
import org.mortbay.jetty.Server
import org.mortbay.jetty.bio.SocketConnector
import org.mortbay.jetty.webapp.WebAppContext

object Start {

  def main(args: Array[String]) {
    val server = new Server()
    val connector = new SocketConnector()

    connector.setMaxIdleTime(1000 * 60 * 60)
    connector.setSoLingerTime(-1)
    connector.setPort(8080)
    server.setConnectors(Array(connector))

    var bb = new WebAppContext()
    bb.setServer(server)
    bb.setContextPath("/")
    bb.setWar("src/main/webapp")

    server.addHandler(bb)

    println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP")
    server.start()
    System.in.read()
    println(">>> STOPPING EMBEDDED JETTY SERVER")
    server.stop()
    server.join()
  }
}
