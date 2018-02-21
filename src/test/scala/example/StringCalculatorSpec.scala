package example

import org.scalatest._

class StringCalculatorSpec extends WordSpec with MustMatchers {

  "StringCalculator" must {

    "Return 0 when given an empty string" in {

      StringCalculator.add("") mustEqual 0
    }

    "Return 1 when given a value '1'" in {

      StringCalculator.add("1") mustEqual 1
    }

    "Return 3 when given '1,2'" in {

      StringCalculator.add("1,2") mustEqual 3
    }

    "Return 42 when given '42'" in {

      StringCalculator.add("42") mustEqual 42
    }

    "Return 6 when given '1,2,3'" in {

      StringCalculator.add("1,2,3") mustEqual 6
    }

    "Return 6 when given '1\n2,3'" in {
      StringCalculator.add("1\n2,3") mustEqual 6
    }

    "Return 3 when given '//;\n1;2'" in {
      StringCalculator.add("//;\n1;2") mustEqual 3
    }
    "Throw IllegalArgumentException when given '1,-2,-3'" in {

      val e = intercept[IllegalArgumentException] {
        StringCalculator.add("1,-2,-3")
      }
    e.getMessage mustEqual "Requirement failed: -2-3"
    }

  }


}
