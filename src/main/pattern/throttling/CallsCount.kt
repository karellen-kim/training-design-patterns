package pattern.throttling

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

/**
 * @author karellen
 */
class CallsCount {

    val tenantCallsCount = ConcurrentHashMap<String, AtomicInteger>()

    fun addTenant(tenant: Tenant) {
        tenantCallsCount.putIfAbsent(tenant.name, AtomicInteger(0))
    }

    fun getCount(name: String): Int? =
        tenantCallsCount.get(name)?.get()

    fun incrementCount(name: String): Int? =
        tenantCallsCount.get(name)?.incrementAndGet()

    fun reset() {
        tenantCallsCount.replaceAll { t, u -> AtomicInteger(0) }
    }

}
