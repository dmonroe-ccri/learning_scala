/* View Bounds */

implicit def strToInt(x: String) = x.toInt

"123"
val y: Int = "123"
math.max("123", 111)

/* This says that A has to be “viewable” as Int. Let’s try it. */
class Container[A <% Int] {def addIt(x: A) = 123 + x}
(new Container[String]).addIt("123")
(new Container[Int]).addIt(123)
/* No implicit view available from Float => Int */
//(new Container[Float]).addIt(123.2F)

/* Other Type Bounds */
class Container2[A](value: A) { def addIt(implicit evidence: A =:= Int) = 123 + value}
(new Container2(123)).addIt
/* Cannot prove that String =:= Int */
//(new Container2("123")).addIt

/* Generic Programming with Views */
/* Does not compile */
//def min[B >: A](implicit cmp: Ordering[B]): A = {
//  if (isEmpty)
//    throw new UnsupportedOperationException("empty.min")
//
//  reduceLeft((x, y) => if (cmp.lteq(x, y)) x else y)
//}

List(1, 2, 3, 4).min
List(1, 2, 3, 4).min(new Ordering[Int] {def compare(a: Int, b:Int) = b compare a})

trait LowPriorityOrderingImplicits {
  implicit def ordered[A <: Ordered[A]]: Ordering[A] = new Ordering[A] {
    def compare(x: A, y: A) = x.compare(y)
  }
}

def foo[A](implicit x: Ordered[A]) {}
def foo2[A: Ordered]{}

implicitly[Ordering[Int]]

trait Contanerx[M[_]] { def put[A](x: A): M[A]; def get[A](m: M[A]): A}
