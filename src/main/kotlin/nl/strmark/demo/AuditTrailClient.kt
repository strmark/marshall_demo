package nl.strmark.demo

import org.springframework.core.io.ClassPathResource
import org.springframework.http.client.JdkClientHttpRequestFactory
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.body
import java.net.http.HttpClient
import java.time.Duration

@Component
class AuditTrailClient(
    val restClientBuilder: RestClient.Builder
) {
    fun getUserid(url: String): String {
        val restClient = restClientBuilder
            .messageConverters { converters -> converters.add(MarshallingHttpMessageConverter( jaxbMarshaller())) }
            .requestFactory(JdkClientHttpRequestFactory(createHttpClient()))
            .build()

        val result = checkNotNull(
            restClient
                .get()
                .uri(url)
                .retrieve()
                .body<AuditTrail>()
        )

        return result.userID
    }

    private fun jaxbMarshaller() = Jaxb2Marshaller().apply {
        setSchema(ClassPathResource("AuditTrail.xsd"))
        setClassesToBeBound(AuditTrail::class.java)
        afterPropertiesSet()
    }

    private fun createHttpClient(): HttpClient {
        return HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).connectTimeout(Duration.ofSeconds(5)).build()
    }
}