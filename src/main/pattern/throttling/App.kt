package pattern.throttling

/**
 * @author karellen
 */
fun main() {
    val count = CallsCount()
    val client1 = Tenant("Client1", 2, count)
    val client2 = Tenant("Client2", 5, count)

    val timer = ThrottleTimerImpl(10, count)
    val service = Service(timer, count)

    (1..20).forEach {
        println("client1 : ${service.call(client1)}")
        println("client2 : ${service.call(client2)}")
        Thread.sleep(1);
    }
}
