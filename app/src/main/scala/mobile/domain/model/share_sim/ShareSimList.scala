package mobile.domain.model.share_sim

import eu.timepit.refined.api.RefType.refinedRefType.{unsafeWrap, unwrap}
import eu.timepit.refined.api.Refined
import eu.timepit.refined.collection.MaxSize
import eu.timepit.refined.refineV

case class ShareSimList(value: Seq[ShareSim] Refined MaxSize[4]) {
  def addShareSim(shareSim: ShareSim): Either[String, ShareSimList] = {
    for {
      restrictedList <- refineV[MaxSize[3]](unwrap(value))
      addedShareSimList = add(restrictedList, shareSim)
    } yield ShareSimList(addedShareSimList)
  }

  private def add[T](s: Seq[T] Refined MaxSize[3], t: T): Seq[T] Refined MaxSize[4] =
    unsafeWrap(s.value.appended(t))
}
