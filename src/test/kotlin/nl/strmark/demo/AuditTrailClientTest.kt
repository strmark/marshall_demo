package nl.strmark.demo

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.client.RestClientException

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuditTrailClientTest {
    @LocalServerPort
    private val port = 0

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Autowired
    private lateinit var auditTrailClient: AuditTrailClient

    @Test
    fun getCorrectAuditTrail() {
        val response = auditTrailClient.getUserid("http://localhost:" + port + "/getXml?name=correct")
        Assertions.assertNotNull(response)
        assert((response) == "strmark")
    }

    @Test
    fun getIncorrectAuditTrail() {
        assertThatExceptionOfType(RestClientException::class.java)
            .isThrownBy {
                auditTrailClient.getUserid("http://localhost:" + port + "/getXml?name=incorrect")
            }
            .withCauseInstanceOf(HttpMessageNotReadableException::class.java)
            .havingCause()
            .havingCause()
            .withMessage("JAXB unmarshalling exception")
    }
}