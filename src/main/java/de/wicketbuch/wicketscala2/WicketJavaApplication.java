package de.wicketbuch.wicketscala2;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketJavaApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    protected void init() {
        getMarkupSettings().setAutomaticLinking(true);
    }
}
