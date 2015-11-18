class HelloClass {
  def inClass() {
    println("In Class")
  }
}

object HelloObjectPlusClass {
  println("In object")
  def main(args: Array[String]) {
    println("In Main")
    val c = new HelloClass
    c.inClass()
  }
  var x: Int = 0
  def increment(i: Int) {
    return i + 1
  }

  def decrement(i: Int){
    i - 1
  }
  println(x)
  x = x + 1
  println(x)
  println(increment(x))
  println(decrement(x))

  val LongString =
    """
      |This
      |Is Indeed a
      |Long string
      |...
      |.
    """.stripMargin
  /* Comment */
  //Also Comment
  println(LongString)

  val a = List(1, 2, 3, 4, 5)
  println(a)
  println(a.isEmpty)

  val b = a drop 3
  val c = a ::: b
  println(c.reverse)

  println(a zip b)

  val d = a :: b
  println(d.flatten)
}
