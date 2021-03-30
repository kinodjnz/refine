package mobile.domain.model.contract

sealed abstract class Plan

object Plan {

  case object _1GB extends Plan

  case object _3GB extends Plan

  case object _30GB extends Plan

}
