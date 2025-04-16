package com.lds.wasm

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json

class Greeting {
    private val platform = getPlatform()

    suspend fun greet(): String {
        val client = HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }

        try {

            val fileName = "test.txt"

            val response = client.post("https://ya.ru") {
                headers {
                    append("Authorization", "Bearer @@@")
                }
                setBody(
                    MultiPartFormDataContent(
                        formData {
                            append("username", "username" ?: "")
                            appendInput(
                                key = "files", // Ключ массива файлов
                                headers = Headers.build {
                                    append(
                                        HttpHeaders.ContentDisposition,
                                        "filename=\"$fileName\""
                                    )
                                }
                                //, size = inputStream.available().toLong() // Размер файла в Long
                                , size = fileSize
                            ) {
                                ....????
                            }


                        }
                    )
                )
            }

            return "Response status: ${response.status.value}, Platform: ${platform.name}"
        } catch (e: Exception) {
            return "Error: ${e.message}, Platform: ${platform.name}"
        } finally {
            client.close()
        }
    }
}