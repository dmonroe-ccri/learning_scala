1 + 1
val two = 1 + 1
var name = "Steve"
name = "Marius"

/* Function */
def addOne(m: Int): Int = m + 1
addOne(3)

val three = addOne(2)

def tres() = 1 + 2
tres
tres()

/* Anonymous function, assigned to anon */
val anon = (x: Int) => x + 1
anon(4)

def timesTwo(i: Int) = {
  println("Allo")
  i*2
}

timesTwo(3)
/* Multiline anonymous */
val t2 = {
  i: Int =>
  println("AlloAllo")
  i*2
}

t2(5)
/* Partial */
def adder(m: Int, n: Int) = m + n
adder(2, 3)
val add2 = adder(2, _: Int)
add2(4)
/*  Curried */
def multiply(m: Int)(n: Int): Int = m*n
multiply(2)(3)
val timesTwoAgain = multiply(2)_
timesTwoAgain(3)
val curriedAdd = (adder _).curried
val addTwoCurry = curriedAdd(2)
addTwoCurry(5)
def capitalizeAll(args: String*) = {
  args.map { arg =>
    arg.capitalize
  }
}

capitalizeAll("astring", "anotherstring")

class Calculator(brand: String) {
  /**
    *  A Constructor.
    */
  val color: String = if(brand == "TI") {
    "blue"
  } else if (brand == "HP") {
    "black"
  } else {
    "white"
  }
  def add(m: Int, n: Int): Int = m + n
}

val calc1 = new Calculator("DiscreetoBurrito")
calc1.color
calc1.add(1, 2)
class C {
  var acc = 0
  def minc = { acc += 1}
  val finc = {() => acc += 1}
}

val c = new C
c.acc
c.minc
c.acc
c.finc
c.acc
c.finc()
c.acc
class ScientificCalc(brand: String) extends Calculator(brand) {
  def log(m: Double, base: Double) = math.log(m)/math.log(base)
}

val SCalc = new ScientificCalc("HP")
SCalc.log(8, 2)
class EvenMoreScientificCalc(brand: String) extends ScientificCalc(brand) {
  def log(m: Int): Double = log(m, math.exp(1))
}

val EMSCalc = new EvenMoreScientificCalc("TI")
EMSCalc.log(8, 2)
EMSCalc.log(8)/EMSCalc.log(2)
abstract class Shape {
  def getArea(): Double
}

class Circle(r: Double) extends Shape {
  def getArea(): Double = {r*r*2*math.Pi}
}

val circ = new Circle(2)
circ.getArea()
trait Car {
  val brand: String
}

trait Shiny {
  val shineRefraction: Int
}

class BMW extends Car with Shiny {
  val brand = "BMW"
  val shineRefraction = 12
}

val Beamer = new BMW
Beamer.brand
Beamer.shineRefraction
/* Types */
trait Cache[K, V] {
  def get(key: K): V
  def put(key: K, value: V)
  def delete(key: K)
  def remove[K](key: K)
}

