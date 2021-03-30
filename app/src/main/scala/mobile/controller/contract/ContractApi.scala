package mobile.controller.contract

import mobile.application.service.contract.ContractService
import mobile.controller.contract.request.ContractApplicationRequest
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RequestMethod, RestController}

import javax.validation.Valid

@RestController
class ContractApi(private val service: ContractService) {
  @RequestMapping(method = Array(RequestMethod.POST), value = Array("contract"))
  def contract(@RequestBody @Valid application: ContractApplicationRequest): String = {
    service.apply(application.toDomainObject).toString + "\n"
  }
}
