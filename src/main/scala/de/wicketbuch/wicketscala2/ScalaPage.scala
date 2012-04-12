package de.wicketbuch.wicketscala2 {
  import org.apache.wicket.behavior.Behavior
  import org.apache.wicket.markup.html.basic.Label
  import org.apache.wicket.markup.html.form.Form
  import org.apache.wicket.markup.html.form.NumberTextField
  import org.apache.wicket.markup.html.WebPage
  import org.apache.wicket.markup.ComponentTag
  import org.apache.wicket.model.IModel
  import org.apache.wicket.Component
  import org.wicketstuff.scala.SLink
  import org.apache.wicket.model.Model

  class ScalaPage extends WebPage {
    import ScalaHelpers._

    val alterForm = new Form("alterForm")
    add(alterForm)

    val person = new Person(17)

    val personModel = new Model(person)

    val alterModel: IModel[Integer] = modelOf(personModel)(_.alter, _.alter = _)

    val alterField = new NumberTextField[Integer]("alterField", alterModel, classOf[Integer])

    alterForm.add(alterField)

    alterField.add(new Behavior() {
      override def onComponentTag(c: Component, tag: ComponentTag) {
        tag.put("style", if (alterModel.getObject() >= 18) "background-color:#88ee88" else "background-color:#ee8888")
      }
    })

    add(new Label("showAlter", alterModel))

    add(new Label("showVolljaehrig", readModel(if (alterModel.getObject() >= 18) "Volljährig" else "Minderjährig")))

    add(new SLink("incrementor", { alterModel.setObject(alterModel.getObject() + 1) }))
  }
}
