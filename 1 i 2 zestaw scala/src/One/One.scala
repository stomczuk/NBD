package One

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object One {
  def main(args: Array[String]) {
    var daysString = "";
    val days = List(
      "Poniedzialek",
      "Wtorek",
      "Sroda",
      "Czwartek",
      "Piatek",
      "Sobota",
      "Niedziela"
    )

    val numbers = List(
      0,
      11,
      32,
      0,
      1
    )

    val numbers2 = List(
      -12,
      -11,
      21,
      0,
      1
    )

    val products = Map(
      "Mleko" -> BigDecimal.valueOf(2.65),
      "Masło" -> BigDecimal.valueOf(4.99),
      "Szynka" -> BigDecimal.valueOf(14.99),
      "Czekolada" -> BigDecimal.valueOf(5.99),
    )
    ex1a(days)
    ex1b(days)
    ex1c(days)
    ex2a(days, daysString)
    ex2b(days, daysString)
    ex3(days, daysString)
    ex4a(days)
    ex4b(days)
    ex4c(days)
    ex5(products)
    ex6(new Tuple3[String, Int, Double]("Hello", 123, 12.11))
    ex7()
    ex8(numbers, new ListBuffer[Int])
    ex9(numbers)
    ex10(numbers2)

  }

  def ex1a(days: List[String]) {
    var daysString: String = "";
    for (day <- days) {
      daysString += day + ", "
    }
    println("Zadanie 1a: " + daysString.substring(0, daysString.length - 2))
  }

  def ex1b(days: List[String]) {
    var daysStartingWithPString: String = "";
    for (day <- days) {
      if (day.startsWith("P")) {
        daysStartingWithPString += day + ", "
      }
    }
    println("Zadanie 1b: " + daysStartingWithPString.substring(0, daysStartingWithPString.length - 2))
  }

  def ex1c(days: List[String]) {
    var daysString: String = "";
    var i = 0
    while (i < days.size) {
      daysString += days(i) + ", "
      i += 1
    }
    println("Zadanie 1c: " + daysString.substring(0, daysString.length - 2))
  }

  def ex2b(days: List[String], daysString: String) {
    days match {
      case day :: tail =>
        ex2b(tail, ", " + day + daysString)
      case Nil => println("Zadanie 2b: " + daysString.substring(2, daysString.length))
    }
  }

  def ex2a(days: List[String], daysString: String) {
    days match {
      case day :: tail =>
        ex2a(tail, daysString + day + ", ")
      case Nil => println("Zadanie 2a: " + daysString.substring(0, daysString.length - 2))
    }
  }


  @tailrec
  def ex3(days: List[String], daysString: String) {
    days match {
      case day :: tail =>
        ex3(tail, daysString + day + ", ")
      case Nil => println("Zadanie 3: " + daysString.substring(0, daysString.length - 2))
    }
  }

  def ex4a(days: List[String]) {
    var daysString: String = "";
    daysString = days.foldLeft(daysString)((s, x) => s + x + ", ")
    println("Zadanie 4a: " + daysString.substring(0, daysString.length - 2))
  }

  def ex4c(days: List[String]) {
    var daysString: String = "";
    daysString = days.foldLeft(daysString)((s, x) => if (x.startsWith("P")) s + x + ", " else s)
    println("Zadanie 4c: " + daysString.substring(0, daysString.length - 2))
  }

  def ex4b(days: List[String]) {
    var daysString: String = "";
    daysString = days.foldRight(daysString)((s, x) => s + ", " + x)
    println("Zadanie 4b: " + daysString.substring(0, daysString.length - 2))
  }

  def ex5(products: Map[String, BigDecimal]) {
    val discount = products map { case (key, value) => (key, 0.9 * value.setScale(1, BigDecimal.RoundingMode.HALF_UP)) }
    println("Zadanie 5: " + discount)
  }

  def ex6(value: (String, Int, Double)): Unit = {
    println("Zadanie 6: " + value._1 + " " + value._2 + " " + value._3)
  }

  def ex7(): Unit = {
    val names = Map(
      "Janusz" -> "Kowalski",
      "Jan" -> "Kowalski"
    )
    println("Zadanie 7: " + names.get("Janusz") + " " + names.get("Beata"))
  }

  def ex8(numbers: List[Int], numbersWithoutZero: ListBuffer[Int]): Unit = {
    numbers match {
      case number :: tail =>
        if (number != 0) {
          numbersWithoutZero.addOne(number)
          ex8(tail, numbersWithoutZero)
        } else ex8(tail, numbersWithoutZero)
      case Nil => println("Zadanie 8: " + numbersWithoutZero.toList)
    }
  }

  def ex9(numbers: List[Int]): Unit = {
    println("Zadanie 9: " + numbers.map(x => x + 1))
  }

  def ex10(numbers: List[Int]): Unit = {
    println("Zadanie 10: " + numbers.map(_.abs))
  }
}
