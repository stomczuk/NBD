package Two

object MainTwo {

  def main(args: Array[String]): Unit = {



    println(ex1("niedziela"))
    println(ex2())
    println(ex3(Osoba("Wojtek", "Wąs")))
    println("Ex4: " + ex4(5, multiplyValue));
    ex5();


  }

  def ex1(day: String) = day match {
     case "poniedziałek" => "Praca"
     case "wtorek" => "Praca"
     case "środa" => "Praca"
     case "czwartek" => "Praca"
     case "piątek" => "Praca"
     case "sobota" => "Weekend"
     case "niedziela" => "Weekend"
     case _ => "Nie ma takiego dnia"
  }

  def ex2() {
    val konto = new KontoBankowe(100)
    println("Stan konta na poczatku " + konto.stanKonta)
    konto.wplata(100)
    println("Stan konta po wpłacie " + konto.stanKonta)
    konto.wyplata(50)
    println("Stan konta po wypłacie " + konto.stanKonta)
  }

  def ex3(p: Osoba) = p match {
    case Osoba("Jan", "Kowalki") => "Cześć Janek"
    case Osoba("Grażyna", "Kowalska") => "Cześć Grażyna, co u Janka?"
    case Osoba(name, surname) => s"Miło mi cię poznać $name $surname"
  }

  def multiplyValue(value: Int): Int = value*2
  def ex4 (value: Int, fun: (Int) => Int) = fun(fun(fun(value)));

  def ex5(): Unit = {
    val osoba1 = new Osoba("Jan", "Kowalski") with Student
    println(s"Podatek studenta: ${osoba1.podatek}%")

    val osoba2 = new Osoba("Anka", "Ankowska") with Pracownik
    println(s"Podatek pracownika: ${osoba2.podatek}%")

    val osoba3 = new Osoba("Alicja", "Alicjowska") with Nauczyciel
    println(s"Podatek nauczyciela: ${osoba3.podatek}%")

    val osoba4 = new Osoba("Artur", "Arturowski") with Student with Pracownik
    println(s"Podatek studenta pracującego: ${osoba4.podatek}%")

    val osoba5 = new Osoba("Roman", "Romanowski") with Pracownik with Student
    println(s"Podatek pracownika studiującego: ${osoba5.podatek}%")
  }




}
