import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PathSpec extends FlatSpec with Matchers {

  val pa = Point("a", 0, 0)
  val pb = Point("b", 10, 10)

  //val ac = Segment(pa, pc)

  "an empty segment" should "compute its  distance" in {
    //val distance = ac.distance
    //distance shouldBe 20.0 +- 0.0001
  }

}
