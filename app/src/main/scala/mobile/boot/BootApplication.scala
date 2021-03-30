package mobile.boot

import mobile.config.ProjectConfiguration
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(Array(classOf[ProjectConfiguration]))
class BootApplication

object BootApplication extends App {
  SpringApplication.run(classOf[BootApplication]);
}
