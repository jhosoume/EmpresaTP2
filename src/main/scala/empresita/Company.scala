package empresita

import java.util.Date

import empresita.sectors._
import empresita.positions._

class Company(name: String) {

  var sectors: SectorContainer = new SectorContainer

  var op_director: Employee = _
  var exec_director: Employee = _

  /*def assign_opDirector(newOp: Employee, newPosition: Position = null): Unit ={
    if(op_director == null)
      newOp.promote(OperationDirector)
    else {
      if (newPosition != null){
        op_director.promote(newPosition)
        newOp.promote(OperationDirector)
      }else{
        //TODO demote() wont work for these directors
      }
    }
    op_director = newOp
  }

  def assign_execDirector(newExec: Employee, newPosition: Position = null): Unit ={
    if(exec_director == null)
      newExec.promote(ExecutiveDirector)
    else {
      if (newPosition != null){
        exec_director.promote(newPosition)
        newExec.promote(ExecutiveDirector)
      }else{
        //TODO demote() wont work for these directors
      }
    }
    op_director = newExec
  }*/

  def add_emp_to_sector(employee: Employee, sector: Sector): Unit = {
    if (sector.valid_employee(employee)) sector.add_emp(employee)
  }

  def hire(person: Person, sector: Sector, position: Position): Unit = {
    val emp = new Employee(person.name, person.CPF, person.birthday, person.qualification,
      this, new Date(), sector, position)
    sector.add_emp(emp)
  }

  /*def fire(empCPF: String): Unit ={
    TODO keep this change?
  }*/
  def fire(emp: Employee): Unit ={
    emp.sector.remove_emp(emp.CPF)
  }//TODO turn employee into just a person?
    //TODO employee is really gone or just inaccessible?

  def salaryAvg(): Double ={
    (sectors.design.salaryAvg()+
    sectors.finance.salaryAvg()+
    sectors.marketing.salaryAvg()+
    sectors.norm.salaryAvg()+
    sectors.tech.salaryAvg())/5
  }

}

