package empresita

import java.text.{DateFormat, SimpleDateFormat}
import java.time.{LocalDate, Period, ZoneId}

import empresita.positions._
import empresita.sectors._
import java.util.Date

object Main extends App {
  val format = new SimpleDateFormat("dd-MM-yyyy")

  val myCom = new Company("Monsters Inc")
  val myCom2 = new Company("Tigus")
  println("¡Hola, mundo!")
  val eu = new Person(name = "It's me, Mario", CPF = "1",
    birthday = format.parse("03-02-1962"), qualification = BasicSchooling)
  val eu2 = new Employee(name = "June", CPF = "5", birthday = format.parse("14-08-1995"),
    company = myCom, join_date = new Date(), sector = new Design, position = Assistant, qualification = Admin)

  println(eu2.getName)
  println(eu.getName)
  Hierarchy.next_pos(ExecutiveDirector)
  Hierarchy.prev_pos(Assistant)


  val IASA = new Company("IASA")

  val luciana = new Person("Luciana", "73464979024",
    format.parse("1947-03-03"), ComputerEngineer)

  IASA.hire(luciana, IASA.sectors.tech, SectorDirector)

  val santiago = new Employee("Santiago", "84112913087",
    format.parse("1948-11-05"), SystemEngineer, IASA, new Date(),
    IASA.sectors.tech, Pro)

  val mariaJ = new Employee("Maria Jose", "85301610090",
    format.parse("1953-09-15"), InformationEngineer, IASA, new Date(),
    IASA.sectors.tech, Pro)

  val juanJ = new Employee("Juan Jose", "61359683003",
    format.parse("1956-08-02"), ComputerEngineer, IASA, new Date(),
    IASA.sectors.tech, Pro)

  val maria = new Employee("Maria", "39873262040",
    format.parse("1959-10-01"), SystemEngineer, IASA, new Date(),
    IASA.sectors.tech, Pro)

  val jose = new Employee("Jose", "06941213043",
    format.parse("1960-04-23"), InformationEngineer, IASA, new Date(),
    IASA.sectors.tech, Technician)

  val salome = new Employee("Salome", "18127308021",
    format.parse("1960-07-26"), ComputerEngineer, IASA, new Date(),
    IASA.sectors.tech, Technician)

  val matias = new Employee("Matias", "45370033080",
    format.parse("1962-02-11"), SystemEngineer, IASA, new Date(),
    IASA.sectors.tech, Technician)

  val dulceM = new Employee("Dulce Maria", "34753805018",
    format.parse("1963-05-05"), SystemEngineer, IASA, new Date(),
    IASA.sectors.tech, Technician)

  val miguelA = new Employee("Miguel Angel", "02403995010",
    format.parse("1965-09-11"), InformationEngineer, IASA, new Date(),
    IASA.sectors.tech, Technician)

  val ana = new Employee("Ana", "84147975046",
    format.parse("1970-04-17"), ComputerEngineer, IASA, new Date(),
    IASA.sectors.tech, Assistant)

  val joao = new Employee("Joao", "54541963043",
    format.parse("1970-12-16"), SystemEngineer, IASA, new Date(),
    IASA.sectors.tech, Assistant)

  val isabella = new Employee("Isabella", "71200425057",
    format.parse("1971-06-14"), InformationEngineer, IASA, new Date(),
    IASA.sectors.tech, Assistant)

  val samuel = new Employee("Samuel", "58863674035",
    format.parse("1974-06-13"), ComputerEngineer, IASA, new Date(),
    IASA.sectors.tech, Assistant)

  val saraS = new Employee("Sara Sofia", "16075209077",
    format.parse("1974-09-17"), SystemEngineer, IASA, new Date(),
    IASA.sectors.tech, Assistant)

  val juanS = new Person("Juan Sebastian", "55582579036",
    format.parse("1976-02-02"), GraphicDesigner)

  IASA.hire(juanS, IASA.sectors.design, SectorDirector)

  val francisca = new Employee("Francisca", "92745945009",
    format.parse("1977-12-04"), MultimediaDesigner, IASA, new Date(),
    IASA.sectors.design, Pro)

  val antonio = new Employee("Antonio", "53081373077",
    format.parse("1979-03-25"), SocialEngineer, IASA, new Date(),
    IASA.sectors.design, Pro)

  val mariana = new Employee("Mariana", "41356518010",
    format.parse("1979-04-14"), GraphicDesigner, IASA, new Date(),
    IASA.sectors.design, Pro)

  val jeronimo = new Employee("Jeronimo", "42461316015",
    format.parse("1980-05-29"), MultimediaDesigner, IASA, new Date(),
    IASA.sectors.design, Pro)

  val luisaF = new Employee("Luisa Fernanda", "56622828032",
    format.parse("1980-12-13"), SocialEngineer, IASA, new Date(),
    IASA.sectors.design, Technician)

  val juanDa = new Employee("Juan David", "03471262008",
    format.parse("1981-08-30"), GraphicDesigner, IASA, new Date(),
    IASA.sectors.design, Technician)

  val antonia = new Employee("Antonia", "33939733040",
    format.parse("1981-12-13"), MultimediaDesigner, IASA, new Date(),
    IASA.sectors.design, Technician)

  val francisco = new Employee("Francisco", "81578884098",
    format.parse("1988-10-02"), SocialEngineer, IASA, new Date(),
    IASA.sectors.design, Technician)

  val gabriela = new Employee("Gabriela", "24732458009",
    format.parse("1989-03-05"), GraphicDesigner, IASA, new Date(),
    IASA.sectors.design, Technician)

  val emmanuel = new Employee("Emmanuel", "44802777060",
    format.parse("1948-11-26"), MultimediaDesigner, IASA, new Date(),
    IASA.sectors.design, Assistant)

  val saraV = new Employee("Sara Valentina", "78374978058",
    format.parse("1949-09-01"), SocialEngineer, IASA, new Date(),
    IASA.sectors.design, Assistant)

  val samuelD = new Employee("Samuel David", "62928517022",
    format.parse("1950-05-20"), GraphicDesigner, IASA, new Date(),
    IASA.sectors.design, Assistant)

  val adriana = new Employee("Adriana", "05058544067",
    format.parse("1951-07-05"), MultimediaDesigner, IASA, new Date(),
    IASA.sectors.design, Assistant)

  val carlos = new Employee("Carlos", "81250323045",
    format.parse("1951-12-07"), SocialEngineer, IASA, new Date(),
    IASA.sectors.design, Assistant)

  val mariangel = new Person("Mariangel", "00861144090",
    format.parse("1953-09-30"), Admin)

  IASA.hire(luciana, IASA.sectors.finance, SectorDirector)

  val emiliano = new Employee("Emiliano", "45862261028",
    format.parse("1956-03-07"), Account, IASA, new Date(),
    IASA.sectors.finance, Pro)

  val mariaF = new Employee("Maria Fernanda", "37453908060",
    format.parse("1957-09-10"), Economist, IASA, new Date(),
    IASA.sectors.finance, Pro)

  val juanP = new Employee("Juan Pablo", "61124739092",
    format.parse("1958-10-30"), Admin, IASA, new Date(),
    IASA.sectors.finance, Pro)

  val juliana = new Employee("Juliana", "88540903016",
    format.parse("1961-11-09"), Account, IASA, new Date(),
    IASA.sectors.finance, Pro)

  val paulo = new Employee("Paulo", "07498871092",
    format.parse("1968-02-25"), Economist, IASA, new Date(),
    IASA.sectors.finance, Technician)

  val valentina = new Employee("Valentina", "32565528035",
    format.parse("1969-07-20"), Admin, IASA, new Date(),
    IASA.sectors.finance, Technician)

  val maximiliano = new Employee("Maximiliano", "18377630036",
    format.parse("1970-02-11"), Account, IASA, new Date(),
    IASA.sectors.finance, Technician)

  val anaS = new Employee("Ana Sofia", "69100103020",
    format.parse("1973-02-23"), Economist, IASA, new Date(),
    IASA.sectors.finance, Technician)

  val andresF = new Employee("Andres Felipe", "57113816010",
    format.parse("1973-03-16"), Admin, IASA, new Date(),
    IASA.sectors.finance, Technician)

  val pedro = new Employee("Pedro", "04988779068",
    format.parse("1974-05-12"), Account, IASA, new Date(),
    IASA.sectors.finance, Assistant)

  val marcia = new Employee("Marcia", "72066445037",
    format.parse("1975-11-18"), Economist, IASA, new Date(),
    IASA.sectors.finance, Assistant)

  val antonella = new Employee("Antonella", "50074898086",
    format.parse("1976-06-02"), Admin, IASA, new Date(),
    IASA.sectors.finance, Assistant)

  val mathias = new Employee("Mathias", "17116406034",
    format.parse("1977-07-06"), Account, IASA, new Date(),
    IASA.sectors.finance, Assistant)

  val anaL = new Employee("Ana Lucia", "65853932012",
    format.parse("1985-06-15"), Economist, IASA, new Date(),
    IASA.sectors.finance, Assistant)

  val juanE = new Person("Juan Esteban", "16169250003",
    format.parse("1986-05-20"), Communication)

  IASA.hire(luciana, IASA.sectors.marketing, SectorDirector)

  val fernanda = new Employee("Fernanda", "01826571086",
    format.parse("1989-01-26"), Admin, IASA, new Date(),
    IASA.sectors.marketing, Pro)

  val lucas = new Employee("Lucas", "39606941051",
    format.parse("1990-04-30"), Market, IASA, new Date(),
    IASA.sectors.marketing, Pro)

  val samantha = new Employee("Samantha", "98408875051",
    format.parse("1991-11-14"), Communication, IASA, new Date(),
    IASA.sectors.marketing, Pro)

  val sebastian = new Employee("Sebastian", "49154414075",
    format.parse("1994-08-21"), Admin, IASA, new Date(),
    IASA.sectors.marketing, Pro)

  val mariaC = new Employee("Maria Camila", "78345527086",
    format.parse("1946-09-18"), Market, IASA, new Date(),
    IASA.sectors.marketing, Technician)

  val juanDi = new Employee("Juan Diego", "38568230008",
    format.parse("1947-11-10"), Communication, IASA, new Date(),
    IASA.sectors.marketing, Technician)

  val luiz = new Employee("Luiz", "60852796048",
    format.parse("1953-07-30"), Admin, IASA, new Date(),
    IASA.sectors.marketing, Technician)

  val patricia = new Employee("Patricia", "77290787080",
    format.parse("1955-02-21"), Market, IASA, new Date(),
    IASA.sectors.marketing, Technician)

  val valeria = new Employee("Valeria", "53247002073",
    format.parse("1955-07-14"), Communication, IASA, new Date(),
    IASA.sectors.marketing, Technician)

  val martin = new Employee("Martin", "42074758006",
    format.parse("1955-11-12"), Admin, IASA, new Date(),
    IASA.sectors.marketing, Assistant)

  val mariaA = new Employee("Maria Alejandra", "79593176071",
    format.parse("1956-05-15"), Market, IASA, new Date(),
    IASA.sectors.marketing, Assistant)

  val angelD = new Employee("Angel David", "35640328002",
    format.parse("1962-08-30"), Communication, IASA, new Date(),
    IASA.sectors.marketing, Assistant)

  val aline = new Employee("Aline", "02191180000",
    format.parse("1963-05-27"), Admin, IASA, new Date(),
    IASA.sectors.marketing, Assistant)

  val marcos = new Employee("Marcos", "12683288042",
    format.parse("1964-01-21"), Market, IASA, new Date(),
    IASA.sectors.marketing, Assistant)

  val sandra = new Person("Sandra", "61188165062",
    format.parse("1964-05-11"), Lawyer)

  IASA.hire(luciana, IASA.sectors.norm, SectorDirector)

  val luis = new Employee("Luis", "28113890084",
    format.parse("1967-10-02"), Communication, IASA, new Date(),
    IASA.sectors.norm, Pro)

  val gabriel = new Employee("Gabriel", "91862487073",
    format.parse("1968-06-08"), Account, IASA, new Date(),
    IASA.sectors.norm, Pro)

  val camila = new Employee("Camila", "78787653087",
    format.parse("1969-02-09"), Lawyer, IASA, new Date(),
    IASA.sectors.norm, Pro)

  val amanda = new Employee("Amanda", "96605967070",
    format.parse("1971-10-26"), Communication, IASA, new Date(),
    IASA.sectors.norm, Pro)

  val rafael = new Employee("Rafael", "78397013024",
    format.parse("1975-11-08"), Account, IASA, new Date(),
    IASA.sectors.norm, Technician)

  val daniel = new Employee("Daniel", "92986237045",
    format.parse("1980-01-09"), Lawyer, IASA, new Date(),
    IASA.sectors.norm, Technician)

  val bruna = new Employee("Bruna", "81169565077",
    format.parse("1981-03-10"), Communication, IASA, new Date(),
    IASA.sectors.norm, Technician)

  val jessica = new Employee("Jessica", "18649946062",
    format.parse("1982-03-16"), Account, IASA, new Date(),
    IASA.sectors.norm, Technician)

  val marcelo = new Employee("Marcelo", "44455661018",
    format.parse("1982-06-03"), Lawyer, IASA, new Date(),
    IASA.sectors.norm, Technician)

  val bruno = new Employee("Bruno", "49094843021",
    format.parse("1985-03-09"), Communication, IASA, new Date(),
    IASA.sectors.norm, Assistant)

  val leticia = new Employee("Leticia", "13126920063",
    format.parse("1990-12-04"), Account, IASA, new Date(),
    IASA.sectors.norm, Assistant)

  val eduardo = new Employee("Eduardo", "34016790077",
    format.parse("1991-06-20"), Lawyer, IASA, new Date(),
    IASA.sectors.norm, Assistant)

  val julia = new Employee("Julia", "01067621091",
    format.parse("1994-12-09"), Communication, IASA, new Date(),
    IASA.sectors.norm, Assistant)

  val felipe = new Employee("Felipe", "14025360039",
    format.parse("1994-12-30"), Account, IASA, new Date(),
    IASA.sectors.norm, Assistant)

  println(IASA.sectors.tech.salaryAvg())
  println(IASA.sectors.design.salaryAvg())
  println(IASA.sectors.design.num_employee())
  println(IASA.salaryAvg())
  println(IASA.sectors.meanSalary())

}
