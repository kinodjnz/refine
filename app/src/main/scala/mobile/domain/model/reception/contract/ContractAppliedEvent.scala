package mobile.domain.model.reception.contract

import mobile.domain.model.contract.{ContractId, Plan}

case class ContractAppliedEvent(id: ContractId, plan: Plan)
