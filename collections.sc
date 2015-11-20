val numberlist = List(1, 2, 3, 4)
Set(1, 1, 2)

val hostPort = ("localhost", 80)
hostPort._1
hostPort._2

hostPort match {
  case ("localhost", port) => println("localhost")
  case (host, port) => println("second")
}

1 -> 2

Map( 1 -> 2)
Map("foo" -> "bar")

def timesTwo(i: Int): Int ={
  i*2
}

Map(1 -> Map("foo" -> "bar"))
//Map("timesTwo" -> { timesTwo()})

trait Option[T] {
  def isDefined: Boolean
  def get: T
  def getOrElse(t: T): T
}

val numbers = Map("one" -> 1, "two" -> 2)
numbers.get("two")
var res1 = numbers.get("three")

val result = if (res1.isDefined) {
  res1.get * 2
} else {
  0
}

val result2 = res1.getOrElse(0) * 2

val result3 = res1 match {
  case Some(n) => n*2
  case None => 0
}

def squared (n: Int) = {
  n*n
}

List(1, 2, 3) map squared

numberlist.map((i: Int) => i*2)
numberlist.map(timesTwo)

val doubled = numberlist.foreach((i: Int) => i*2)

numberlist.filter((i: Int) => i%2 == 0)

def isEven(i: Int): Boolean = i % 2 == 0

numberlist.filter(isEven _)

List(1, 2, 3).zip(List("a", "b", "c"))

val longnumlist = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
longnumlist.partition(_ < 4)

longnumlist.find((i: Int) => i > 5)

longnumlist.drop(5)

longnumlist.dropWhile(_ % 4 != 0)

longnumlist.foldRight(0){ (m: Int, n: Int) => println("m: " + m + " n: " + n); m + n }
val nestedNumbers = List(List(1, 2, 3), List(4, 5, 6))
nestedNumbers.flatten
nestedNumbers.map((x: List[Int]) => x.map(_ * 2)).flatten
def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
  numbers.foldRight(List[Int]()) { (x: Int, xs: List[Int]) =>
    fn(x) :: xs
  }
}
ourMap(longnumlist, timesTwo(_))
val extensions = Map("steve" -> 100, "bob" -> 101, "joe"->201)
extensions.filter((namePhone: (String, Int)) => namePhone._2 < 200)
extensions.filter({case (name, extension) => extension >= 101})