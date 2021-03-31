package mobile.controller.share_sim

import eu.timepit.refined.refineMV
import mobile.controller.share_sim.request.ShareSimRequest
import mobile.domain.model.share_sim.ShareSim
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RequestMethod, RestController}

import javax.validation.Valid

@RestController
class ShareSimApi() {
  @RequestMapping(method = Array(RequestMethod.POST), value = Array("share_sim"))
  def contract(@RequestBody @Valid request: ShareSimRequest): String = {
    val shareSimList = request.toDomainObject
    shareSimList.addShareSim(ShareSim(refineMV("x"))).toString + "\n"
  }
}
