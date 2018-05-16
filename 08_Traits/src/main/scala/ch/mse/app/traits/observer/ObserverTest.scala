package ch.mse.app.traits.observer

object ObserverTest {

  trait Observer {
    def update(subject: Any)
  }

  trait Observable {
    var observers : List[Observer] = Nil
    def addObserver(o: Observer): Unit = observers = o :: observers
    def notify(a: Any) = observers.foreach(_.update(a))
    def removeObserver(o: Observer) = observers = observers.filterNot(_ == o)
  }

  class Model(private var value: Int) {
    def getValue = value
    def setValue(value: Int) = { this.value = value }
  }

  class ObservableModel(init: Int) extends Model(init) with Observable {
    override def setValue(value: Int) = {
      super.setValue(value);
      notify(value);
    }
  }

  class Counter extends Observer{
    var counter = 0
    def update(subject: Any) = counter += 1
  }

  def main(args: Array[String]): Unit = {
    val m = new ObservableModel(0)
    val c = new Counter
    m.addObserver(c)
    m.setValue(3);
    m.setValue(5);
    println(c.counter) // Ausgabe: 2, da zwei Notifikationen eingegangen sind
  }

}