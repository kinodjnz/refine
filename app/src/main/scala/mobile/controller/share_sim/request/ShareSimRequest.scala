package mobile.controller.share_sim.request

import cats.data.ValidatedNel
import com.fasterxml.jackson.annotation.JsonProperty
import eu.timepit.refined.api.RefType.refinedRefType.unsafeWrap
import eu.timepit.refined.collection.{MaxSize, NonEmpty}
import eu.timepit.refined.refineV
import mobile.domain.model.share_sim.{Msisdn, ShareSim, ShareSimList}

import javax.validation.constraints.NotNull

case class ShareSimRequest() {
  @JsonProperty("count")
  @NotNull
  var count: Int = _

  def toDomainObject: ShareSimList = ShareSimList(refineV[MaxSize[4]](
    (1 to count)
      .map(_.toString)
      .map(unsafeWrap[String, NonEmpty])
      .map(ShareSim)
      .asInstanceOf[Seq[ShareSim]]
  ).left.map(new RuntimeException(_)).toTry.get)

  def abc: ValidatedNel[String, Msisdn] = Msisdn("hoge")
}
