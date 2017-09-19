package nl.wykorijnsburger.recordstores.anyoldtime

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("/anyoldtime")
class AnyOldTimeController(val anyOldTimeService: AnyOldTimeService) {

    @CrossOrigin
    @GetMapping("/records")
    fun getRecords(@RequestParam("artist") artist: String?) = anyOldTimeService.searchRecords(artist)
            .take(20)

}