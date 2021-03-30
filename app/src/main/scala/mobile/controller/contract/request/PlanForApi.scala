package mobile.controller.contract.request

import enumeratum.{Enum, EnumEntry}
import mobile.domain.model.contract.Plan

sealed abstract class PlanForApi(val value: String, val plan: Plan) extends EnumEntry

object PlanForApi extends Enum[PlanForApi] {

  case object _1GB extends PlanForApi("1GB", Plan._1GB)

  case object _3GB extends PlanForApi("3GB", Plan._3GB)

  case object _30GB extends PlanForApi("30GB", Plan._30GB)

  lazy val values: IndexedSeq[PlanForApi] = findValues

  def of(planString: String): PlanForApi = values
    .filter(_.value == planString)
    .head

  def toApiValue(plan: Plan): PlanForApi = plan match {
    case Plan._1GB => PlanForApi._1GB
    case Plan._3GB => PlanForApi._3GB
    case Plan._30GB => PlanForApi._30GB
  }
}
