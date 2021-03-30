package mobile.application.service.contract

import mobile.domain.model.contract.{ContractApplication, ContractId}
import mobile.domain.model.reception.contract.ContractReceptionStatus
import mobile.domain.service.reception.contract.ContractReception
import org.springframework.stereotype.Service

@Service
class ContractService(private val reception: ContractReception) {
  def apply(application: ContractApplication): ContractResult = {
    reception.apply((() => ContractId("2"), ))(application) match {
      case ContractReceptionStatus.Applied(event) => ContractResult.Applied(event)
      case ContractReceptionStatus.Conflict(existing) => ContractResult.Conflict(existing)
      case ContractReceptionStatus.Duplicate(existing) => ContractResult.Duplicate(existing)
      case ContractReceptionStatus.ValidationError => ContractResult.ValidationError
    }
  }
}
