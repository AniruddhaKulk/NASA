package com.anikulki.nasa.repository

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.nio.charset.StandardCharsets

@RunWith(JUnit4::class)
class NasaRepositoryImplTest {

    private lateinit var nasaRepositoryImpl: NasaRepositoryImpl

    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setup(){
        nasaRepositoryImpl = NasaRepositoryImpl()
        mockWebServer = MockWebServer()
    }

    @Test
    fun getNasaImagesList() {
        enqueueResponse("data.json")
        val data = nasaRepositoryImpl.getNasaImagesList()
        assertThat(data, notNullValue())
        assertThat(data.size, `is`(26))
        assertThat(data[0].title, `is`("Starburst Galaxy M94 from Hubble"))
        assertThat(data[0].explanation, `is`("Why does this galaxy have a ring of bright blue stars?  Beautiful island universe Messier 94 lies a mere 15 million light-years distant in the northern constellation of the Hunting Dogs (Canes Venatici). A popular target for Earth-based astronomers, the face-on spiral galaxy is about 30,000 light-years across, with spiral arms sweeping through the outskirts of its broad disk. But this Hubble Space Telescope field of view spans about 7,000 light-years across M94's central region. The featured close-up highlights the galaxy's compact, bright nucleus, prominent inner dust lanes, and the remarkable bluish ring of young massive stars. The ring stars are all likely less than 10 million years old, indicating that M94 is a starburst galaxy that is experiencing an epoch of rapid star formation from inspiraling gas. The circular ripple of blue stars is likely a wave propagating outward, having been triggered by the gravity and rotation of a oval matter distributions. Because M94 is relatively nearby, astronomers can better explore details of its starburst ring.    Astrophysicists: Browse 2,000+ codes in the Astrophysics Source Code Library"))
        assertThat(data[0].date, `is`("2019-12-01"))
        assertThat(data[0].url, `is`("https://apod.nasa.gov/apod/image/1912/M94_Hubble_960.jpg"))
    }


    private fun enqueueResponse(fileName: String, headers: Map<String, String> = emptyMap()){
        val inputStream = javaClass.classLoader
            ?.getResourceAsStream("dummy-response/$fileName")
        val source = inputStream?.source()?.buffer() ?: return
        val mockResponse = MockResponse()
        for((key, value) in headers){
            mockResponse.addHeader(key, value)
        }
        mockWebServer.enqueue(mockResponse.setBody(source.readString(StandardCharsets.UTF_8)))
    }

    @After
    fun stopService() {
        mockWebServer.shutdown()
    }
}