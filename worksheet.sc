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