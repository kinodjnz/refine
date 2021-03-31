package mobile.domain.model.share_sim

import cats.data.ValidatedNel
import cats.implicits._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.refineV
import eu.timepit.refined.string.MatchesRegex
import mobile.domain.model.share_sim.Msisdn.MsisdnType

case class Msisdn(value: String Refined MsisdnType)

object Msisdn {
  type MsisdnType = MatchesRegex["0[2789]0[0-9]{8}"]

  def apply(value: String): ValidatedNel[String, Msisdn] =
    refineV[MsisdnType](value).toValidatedNel.map(Msisdn(_))
}
