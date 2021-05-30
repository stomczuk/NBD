package Two

class KontoBankowe(poczatkowyStanKonta: Int = 0) {


  var stanKonta: Int = poczatkowyStanKonta

  def this() {this(0)}

  def wplata(wplata: Int): Unit = {
     stanKonta += wplata
  }

  def wyplata(wyplata: Int): Unit = {
     stanKonta -= wyplata
  }


}
