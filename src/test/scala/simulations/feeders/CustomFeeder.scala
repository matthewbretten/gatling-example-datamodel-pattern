package feeders

import io.gatling.core.Predef._
import io.gatling.core.feeder.FeederBuilder
import com.github.matthewbretten.Basket
import com.github.matthewbretten.objects.NewBasket

object CustomFeeder {
    def basket(): Iterator[Map[String,Any]] = {
        Iterator.continually{
            val basket: Basket = NewBasket.getBasket()
            Map[String, Any](
                ("basket" -> basket.toJson(false))
            )
        }
    }

}