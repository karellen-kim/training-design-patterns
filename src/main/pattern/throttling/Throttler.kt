package pattern.throttling

import java.util.*

/**
 * @author karellen
 */
interface Throttler {
    fun start()
}

class ThrottleTimerImpl(val throttlePeriod: Long, val callsCount: CallsCount): Throttler {
    override fun start() {
        Timer(true)
            .schedule(object:TimerTask() {
                override fun run() {
                    callsCount.reset()
                }
            }, 0, throttlePeriod)
    }
}
