package mobile.controller.contract.request

import com.fasterxml.jackson.annotation.JsonProperty
import mobile.domain.model.contract.ContractApplication

import javax.validation.constraints.NotNull

case class ContractApplicationRequest() {
  @JsonProperty("plan")
  @NotNull
  var plan: String = _

  @JsonProperty("entameFree")
  @NotNull
  var entameFree: String = _

  def toDomainObject: ContractApplication = {
    ContractApplication(
      PlanForApi.of(plan).plan,
      EntameFreeApplicationForApi.of(entameFree).entameFree
    )
  }
}
