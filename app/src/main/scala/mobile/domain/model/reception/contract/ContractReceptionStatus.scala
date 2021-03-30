package mobile.domain.model.reception.contract

import mobile.domain.model.contract.Contract

sealed abstract class ContractReceptionStatus

object ContractReceptionStatus {

  case class Applied(event: ContractAppliedEvent) extends ContractReceptionStatus

  case class Conflict(existing: Contract) extends ContractReceptionStatus

  case class Duplicate(existing: Contract) extends ContractReceptionStatus

  case object ValidationError extends ContractReceptionStatus

}
