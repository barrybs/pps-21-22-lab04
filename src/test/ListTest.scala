
import org.junit._
import org.junit.Assert._
import u04lab.code.List._

class ListTest {

  @Test def testListFactory() : Unit =
    assertEquals(Cons("a", Cons("b", Cons("c", Nil()))), List("a","b","c"))
}
