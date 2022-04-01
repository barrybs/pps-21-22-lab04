package u04lab.polyglot.a01a

import Logics.*
import u04lab.polyglot.Pair
import u04lab.code.List._
import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val size: Int, private val boat: Int) extends Logics:
  private val FAILURES : Int = 0
  private var hit : u04lab.code.List[Tuple2[Int,Int]] = Nil()
  private val r = Random()
  private val boatRow = r.nextInt(size)
  private val boatLeftCol: Int = r.nextInt(size - boat + 1)
  private var failures: Int = 0

  def hit(row: Int, col: Int): Result =
    if (row == boatRow && col >= boatLeftCol && col < boatLeftCol + boat)
      hit = Cons((row,col), hit)
      if length(hit) == boat then
        Result.WON
      else
        Result.HIT
    else
      failures += 1
      if failures == FAILURES then
        Result.LOST
      else
        Result.MISS