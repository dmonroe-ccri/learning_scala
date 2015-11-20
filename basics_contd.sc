class Foo {}
object FooMaker {
  def apply() = new Foo
}
val newFoo = FooMaker()
class Bar {
  def apply() = 0
}
val bar = new Bar()
bar()
object Timer {
  var count = 0
  def currentCount(): Long = {
    count += 1
    count
  }
}
Timer.currentCount()
Timer.currentCount()
class Bar2(foo: String)
object Bar2 {
  def apply(foo: String) = new Bar2(foo)
}

object addOne extends Function1[Int, Int] {
  def apply(m: Int): Int = m + 1
}

addOne(1)

class AddOne extends Function1[Int, Int] {
  def apply(m: Int): Int = m + 1
}

object colorHolder {
  val BLUE = "Blue"
  val RED = "Red"
}

println("the color is: " + colorHolder.BLUE)
/* Pattern Matching */
val times = 1
times match {
  case i if i == 1 => "One"
  case i if i == 2 => "Two"
  case _ => "some other number"
}

case class Calculator(brand_ : String, model_ : String) {
  /**
    *  A Constructor.
    */
  val brand = brand_
  val model = model_

  val color: String = if(brand == "TI") {
    "blue"
  } else if (brand == "HP") {
    "black"
  } else {
    "white"
  }
  def add(m: Int, n: Int): Int = m + n
}

val calc = new Calculator("HP", "31B")
calc.brand
calc.color
def calcType(calc: Calculator) = calc match {
  case _ if calc.brand == "HP" && calc.model == "20B" => "financial"
  case _ if calc.brand == "HP" && calc.model == "48B" => "scientific"
  case _ if calc.brand == "HP" && calc.model == "30B" => "business"
  case _ => "Calculator: %s %s is of unknown type".format(calc.brand, calc.model)
}

calcType(calc)
val hp20b = Calculator("HP", "20B")
val HP20B = Calculator("HP", "20B")
hp20b == HP20B
val hp30b = Calculator("HP", "30B")
def caseCalcType(calc: Calculator) = calc match {
  case Calculator("HP", "20B") => "financial"
  case Calculator("HP", "30B") => "business"
  case Calculator("HP", "48B") => "scientific"
  case c@Calculator(_, _) => "%s is of unknown type.".format(c)
}

caseCalcType(hp20b)
caseCalcType(hp30b)
caseCalcType(calc)
try {
  remoteCalculatorService.add(1, 2)
} catch {
  case e: ServerIsDownException => log.error(e "the remote calculator service is unavailable." +
    "  should have kept your trusty HP.")
} finally {
  remoteCalculatorService.close()
}