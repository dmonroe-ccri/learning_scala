/* Concatenation */
val xlist = 2 :: 1 :: "bar" :: Nil :: "foo" :: Nil
/* concatenation with generic data means we cannot resolve type information */
xlist.head

/* Specifying the type variable A gives us polymorphism */
def drop1[A](l: List[A]) = l.tail
drop1(List(1, 2, 3))

/* Rank 1 Polymorphism...  what? */
def toList[A](a: A) = List(a)

/* These Fail - Don't do these */
//def foo[A, B](f: A => List[A], b: B) = f(b)
//def foo[A](f: A => List[A], b: Int) = f(b)

/* Type Inference */
def id[T](x: T) = x
val x0 = id(322)
val x1 = id("hey")
val x2 = id(Array(1, 2, 3, 4))

class Covariant[+A]
val cv1: Covariant[AnyRef] = new Covariant[String]
/* Fails... String is a subtype of Anything, but not vice versa */
//val cv2: Covariant[String] = new Covariant[AnyRef]

class Contravariant[-A]
val cv3: Contravariant[String] = new Contravariant[AnyRef]
/* Fails because of the opposite. */
//val cv4: Contravariant[AnyRef] = new Contravariant[String]

trait Function1 [-T1, +R] extends AnyRef

class Animal {val sound = "rustle"}
class Bird extends Animal {override val sound = "call"}
class Chicken extends Bird {override val sound = "cluck"}

val getTweet: (Bird => String) = (a: Animal) => a.sound

/* Return values are covariant */
val hatch: (() => Bird) = (() => new Chicken)

//def cacophany[T](things: Seq[T]) = things map (_.sound)
/* T needs to be a subtype of Animal */
def biophany[T <: Animal](things: Seq[T]) = things map (_.sound)

val flock = List(new Bird, new Bird)
new Chicken :: flock
/* List also defines ::[B >: T](x: B) which returns a List[B].
   Notice the B >: T. That specifies type B as a superclass of T.
   That lets us do the right thing when prepending an Animal to a List[Bird]: */
new Animal :: flock

/* Quantification */
def count[A](l: List[A]) = l.size
def count_anon_type[_](l: List[_]) = l.size

/* This produces "List[Any]" */
def drop2(l: List[_]) = l.tail

/* Gives warning... I disabled it just so I didn't see it for further examples. */
//def drop3(l: List[T forSome {type T}]) = l.tail
def hashcodes(l: Seq[_ <: AnyRef]) = l map (_.hashCode)
/* Produces a type mismatch without asInstanceOf[AnyRef] - weird hashes come out too. */
hashcodes(Seq(1.asInstanceOf[AnyRef], 2.asInstanceOf[AnyRef], 3.asInstanceOf[AnyRef], 4.asInstanceOf[AnyRef]))

hashcodes(Seq("one", "two", "three", "four"))