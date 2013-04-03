import org.specs2.mutable._

class HelloSpec extends Specification {
  "Hello method returns 'hello'" in {
     Hello.hello must be equalTo("hello")
  }
}
