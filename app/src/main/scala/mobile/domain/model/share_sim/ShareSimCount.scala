package mobile.domain.model.share_sim

import eu.timepit.refined.api.RefType.refinedRefType
import eu.timepit.refined.api.RefType.refinedRefType.{unsafeWrap, unwrap}
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.numeric.LessEqual
import eu.timepit.refined.refineV
import mobile.domain.model.share_sim.ShareSimCount.{CountType, IncreasableCountType}

case class ShareSimCount(count: Int Refined CountType) {
  def add(): Either[String, ShareSimCount] = {
    for {
      restrictedCount <- refineV[IncreasableCountType](unwrap(count))
      newCount = increase(restrictedCount)
    } yield (ShareSimCount(newCount))
  }

  def increase(x: Int Refined IncreasableCountType): Int Refined CountType = unsafeWrap(x + 1)
}

object ShareSimCount {
  type MaxShareSimCount = 4
  type MaxIncreasableShareSimCount = 3
  type CountType = LessEqual[MaxShareSimCount]
  type IncreasableCountType = LessEqual[MaxIncreasableShareSimCount]
  type IntCountType = Int Refined CountType
  type IntIncreasableCountType = Int Refined IncreasableCountType
}
