package ch.mse.app.traits

object IntQueueTest {

  abstract class IntQueue {
    def get(): Int
    def put(x: Int)
  }

  class BasicIntQueue extends IntQueue {
    private val buf =
      new scala.collection.mutable.ArrayBuffer[Int]
    def get() = buf.remove(0)
    def put(x: Int) { buf += x }
  }

  trait Doubling extends IntQueue {
    abstract override def put(x: Int) { super.put(2 * x); }
  }

  trait Incrementing extends IntQueue {
    abstract override def put(x: Int) { super.put(x + 1); }
  }

  trait Filtering extends IntQueue {
    abstract override def put(x: Int) {
      if (filter(x)) super.put(x)
    }
    val filter: Int => Boolean
  }

  def main(args: Array[String]): Unit = {
    val q = new BasicIntQueue with Filtering {
      val filter = x => BigInt(x).isProbablePrime(100)
    }
    for (i <- 1 to 100) q.put(i)
    for (i <- 1 to 10) println(q.get)
  }

}