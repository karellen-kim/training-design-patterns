package pattern.throttling

/**
 * @author karellen
 */
class Service {
    val count: CallsCount

    constructor(timer: Throttler, count: CallsCount) {
        this.count = count
        timer.start()
    }

    fun call(tenant: Tenant): Int? {
        if (count.getCount(tenant.name) ?: 0 >= tenant.allowedCallsPerSecond) {
            return -1
        }

        return count.incrementCount(tenant.name)
    }
}
