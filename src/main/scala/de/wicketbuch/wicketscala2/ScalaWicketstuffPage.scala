package de.wicketbuch.wicketscala2 {
  import org.apache.wicket.markup.html.WebPage
  import org.apache.wicket.markup.html.form.Form
  import org.apache.wicket.model.IModel
  import org.wicketstuff.scala.Fodel
  import org.wicketstuff.scala.ScalaWicket

  class Person(var alter: Int)

  class ScalaWicketstuffPage extends WebPage with ScalaWicket {

    val alterForm = new Form("alterForm")
    add(alterForm)

    val person = new Person(17)

    val alterModel: IModel[Int] = new Fodel(person.alter, person.alter = _)

    // alternativ:
    // implizit konvertierte funktion, nur get, nicht set:
    var numberModelImplicit: IModel[Int] = { number }
  }
}
