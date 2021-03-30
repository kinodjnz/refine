package mobile.domain.service.reception.contract

import mobile.domain.model.contract.{ContractApplication, ContractId}
import mobile.domain.model.reception.contract.{ContractAppliedEvent, ContractReceptionStatus}
import org.springframework.stereotype.Component

@Component
class ContractReception {
  type ApplyReceptionReader = (() => ContractId, )

  def apply(reader: ApplyReceptionReader)(application: ContractApplication): ContractReceptionStatus =
    ContractReceptionStatus.Applied(ContractAppliedEvent(reader._1(), application.plan))
}
