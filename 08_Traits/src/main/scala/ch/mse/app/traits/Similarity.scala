package ch.mse.app.traits

object Similarity {

  trait Similarity {
    def isSimilar(x: Any): Boolean
    def isNotSimilar(x: Any): Boolean = !isSimilar(x)
  }

  class Point(var x: Int, var y: Int) extends Similarity {
    def isSimilar(obj: Any) =            // two points are considered equal if their x coordinates are equal
      obj.isInstanceOf[Point] &&
        obj.asInstanceOf[Point].x == x

  }

  def main(args: Array[String]): Unit = {
    val p1 = new Point(1, 2)
    val p2 = new Point(1, 3)
    val p3 = new Point(2, 3)

    println("isSimilar")
    println(p1 isSimilar p2)
    println(p1 isSimilar p3)
    println(p2 isSimilar p3)

    println("\nisNotSimilar")
    println(p1 isNotSimilar p2)
    println(p1 isNotSimilar p3)
    println(p2 isNotSimilar p3)
  }

}
