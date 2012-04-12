package de.wicketbuch.wicketscala2

import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.util.convert.converter.SqlDateConverter

class WicketScalaApplication extends WebApplication {
  override def getHomePage() = classOf[HomePage]

  override def init() {
    getMarkupSettings().setAutomaticLinking(true);
  }
}
