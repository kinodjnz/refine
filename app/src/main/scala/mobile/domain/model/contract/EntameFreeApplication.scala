package mobile.domain.model.contract

sealed abstract class EntameFreeApplication

object EntameFreeApplication {

  case object Applying extends EntameFreeApplication

  case object NotApplying extends EntameFreeApplication

}
