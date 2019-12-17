package pattern.throttling

/**
 * @author karellen
 */
class Tenant {
    val name: String
    val allowedCallsPerSecond: Int

    constructor(name: String, allowedCallsPerSecond: Int, count: CallsCount) {
        this.name = name
        this.allowedCallsPerSecond = allowedCallsPerSecond
        count.addTenant(this)
    }
}
