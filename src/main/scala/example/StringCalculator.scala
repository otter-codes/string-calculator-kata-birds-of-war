package example


object StringCalculator extends App {


    def add(numbers: String): Int = {
      if (numbers == "") {
        0
      } else {
        val pattern = "[0-9]+".r
        val negs = "[-][0-9]+".r
        val negList = negs.findAllIn(numbers).toList
        negList.length match {
          case 0 =>
            val y = pattern.findAllIn(numbers).toList
            y.map(_.toInt).sum
          case _ =>
            throw new IllegalArgumentException(s"Requirement failed: ${negList.mkString}")
        }
      }
    }
}
