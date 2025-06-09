package nl.strmark.demo

import org.springframework.http.MediaType.APPLICATION_XML_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AuditTrailController {

    @GetMapping(value = ["/getXml"], produces = [APPLICATION_XML_VALUE])
    fun getXml(@RequestParam(value = "name", defaultValue = "correct") name: String): AuditTrail {
        return when (name) {
            "correct" -> AuditTrail("strmark")
            else -> AuditTrail("0123456789012345678901234567890123456789")
        }
    }

}