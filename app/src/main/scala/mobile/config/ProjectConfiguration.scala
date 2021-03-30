package mobile.config

import mobile.application.service.ApplicationServiceComponentScan
import mobile.controller.ControllerComponentScan
import mobile.domain.service.reception.contract.DomainServiceComponentScan
import org.springframework.context.annotation.{Configuration, Import}

@Configuration
@Import(Array(
  classOf[ControllerComponentScan],
  classOf[ApplicationServiceComponentScan],
  classOf[DomainServiceComponentScan]
))
class ProjectConfiguration {
}
