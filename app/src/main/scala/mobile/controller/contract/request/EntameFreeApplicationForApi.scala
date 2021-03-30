package mobile.controller.contract.request

import enumeratum.{Enum, EnumEntry}
import mobile.domain.model.contract.EntameFreeApplication

sealed abstract class EntameFreeApplicationForApi(val value: String, val entameFree: EntameFreeApplication) extends EnumEntry

object EntameFreeApplicationForApi extends Enum[EntameFreeApplicationForApi] {

  case object Applying extends EntameFreeApplicationForApi("Applying", EntameFreeApplication.Applying)

  case object NotApplying extends EntameFreeApplicationForApi("NotApplying", EntameFreeApplication.NotApplying)

  lazy val values: IndexedSeq[EntameFreeApplicationForApi] = findValues

  def of(entameFree: String): EntameFreeApplicationForApi = values
    .filter(_.value == entameFree)
    .head

  def toApiValue(entameFree: EntameFreeApplication): EntameFreeApplicationForApi = entameFree match {
    case EntameFreeApplication.Applying => EntameFreeApplicationForApi.Applying
    case EntameFreeApplication.NotApplying => EntameFreeApplicationForApi.NotApplying
  }
}
