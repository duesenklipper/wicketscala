package de.wicketbuch.wicketscala2;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

public class JavaPage extends WebPage {
    public static class Person {
        private int alter;

        public int getAlter() {
            return alter;
        }

        public void setAlter(int value) {
            this.alter = value;
        }
    }

    public JavaPage() {
        Form<Void> alterForm = new Form("alterForm");
        this.add(alterForm);
        final Person person = new Person();
        final IModel<Integer> alterModel = new PropertyModel<Integer>(person, "alter");

        NumberTextField<Integer> alterField = new NumberTextField<Integer>("alterField", alterModel, Integer.class);
        alterForm.add(alterField);
        alterField.add(new Behavior() {
            @Override
            public void onComponentTag(Component component, ComponentTag tag) {
                if (((alterModel.getObject() >= 18))) {
                    tag.put("style", "background-color:#88ee88");
                } else {
                    tag.put("style", "background-color:#ee8888");
                }
            }
        });

        this.add(new Label("showAlter", alterModel));
        this.add(new Label("showVolljaehrig", new AbstractReadOnlyModel<String>() {
            @Override
            public String getObject() {
                if (alterModel.getObject() >= 18) {
                    return "Volljährig";
                } else {
                    return "Minderjährig";
                }
            }
        }));

        this.add(new Link<Void>("incrementor") {
            @Override
            public void onClick() {
                alterModel.setObject(alterModel.getObject() + 1);
            }
        });
    }
}
