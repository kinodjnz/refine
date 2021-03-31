package mobile.domain.model.share_sim

import eu.timepit.refined.api.Refined
import eu.timepit.refined.collection.NonEmpty

case class ShareSim(value: String Refined NonEmpty)
