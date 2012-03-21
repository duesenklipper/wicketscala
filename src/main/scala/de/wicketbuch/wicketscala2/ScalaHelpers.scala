package de.wicketbuch.wicketscala2 {
  import org.apache.wicket.Component
  import org.apache.wicket.behavior.Behavior
  import org.apache.wicket.markup.ComponentTag
  import org.apache.wicket.model.IModel
  import org.apache.wicket.model.LoadableDetachableModel
  import org.apache.wicket.model.AbstractReadOnlyModel

  object ScalaHelpers {
    object behavior {
      def afterRender(fun: Component ⇒ Unit) = new Behavior {
        override def afterRender(comp: Component) {
          fun(comp)
        }
      }

      def onComponentTag(fun: (Component, ComponentTag) ⇒ Unit) = new Behavior {
        override def onComponentTag(comp: Component, tag: ComponentTag) {
          fun(comp, tag)
        }
      }
    }

    def readModel[T](get: ⇒ T): IModel[T] = new AbstractReadOnlyModel[T] {
      override def getObject(): T = get
    }

    def readModelOf[T, U](target: T)(get: T ⇒ U): IModel[U] = new AbstractReadOnlyModel[U] {
      override def getObject(): U = get(target)
    }
    def readModelOf[T, U](target: IModel[T])(get: T ⇒ U): IModel[U] = new AbstractReadOnlyModel[U] {
      override def getObject(): U = get(target.getObject())
      override def detach() = target.detach()
    }

    def model[T](get: ⇒ T, set: T ⇒ Unit): IModel[T] = new IModel[T] {
      override def getObject(): T = get

      override def setObject(obj: T) { set(obj) }

      override def detach() {}
    }

    def modelOf[T, U](target: T)(get: T ⇒ U, set: (T, U) ⇒ Unit): IModel[U] = new IModel[U] {
      override def getObject(): U = get(target)

      override def setObject(value: U): Unit = { set(target, value) }

      override def detach(): Unit = ()
    }
    def modelOf[T, U](target: IModel[T])(get: T ⇒ U, set: (T, U) ⇒ Unit): IModel[U] = new IModel[U] {
      override def getObject(): U = {
        get(target.getObject())
      }

      override def setObject(value: U): Unit = { set(target.getObject(), value) }

      override def detach(): Unit = target.detach()
    }

    def ldm[T](model: IModel[T]): IModel[T] = new LoadableDetachableModel[T] {
      override def load(): T = model.getObject()

      override def detach() {
        super.detach()
        model.detach()
      }
    }
  }
}
