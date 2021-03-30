package mobile.application.service.contract

import mobile.domain.model.contract.Contract
import mobile.domain.model.reception.contract.ContractAppliedEvent

sealed abstract class ContractResult

object ContractResult {

  case class Applied(event: ContractAppliedEvent) extends ContractResult

  case class Conflict(existing: Contract) extends ContractResult

  case class Duplicate(existing: Contract) extends ContractResult

  case object ValidationError extends ContractResult

}
