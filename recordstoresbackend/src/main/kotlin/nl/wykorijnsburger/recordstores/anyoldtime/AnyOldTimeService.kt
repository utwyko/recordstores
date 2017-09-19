package nl.wykorijnsburger.recordstores.anyoldtime

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.toFlux

@Service
class AnyOldTimeService(val anyOldTimeClient: AnyOldTimeClient) {

    val records = javaClass.classLoader.getResource("anyoldtime_WWW-LP.txt")
            .openStream()
            .parse()

    fun searchRecords(artistName: String? = null): List<Record> {
        if (artistName != null) {
            return records.filter { it.artistName.toLowerCase().contains(artistName.toLowerCase()) }
        }

        return records
    }
}