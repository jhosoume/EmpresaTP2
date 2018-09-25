package empresita

import empresita.sectors._

import scala.collection.mutable

class Company(name: String) {

  var sectors: mutable.HashMap[String, Sector] = mutable.HashMap(

  )

  def change_sector(name: String) : Unit = {

  }

}
