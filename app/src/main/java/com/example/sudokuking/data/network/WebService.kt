package com.example.sudokuking.data.network

import kotlinx.serialization.Serializable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface WebService {
    @POST("v1/signInUser")
    suspend fun signUp(@Body request: SignUpRequestDto): LoginResponseDto

    @POST("v1/logInUser")
    suspend fun logIn(@Body request: SignUpRequestDto): LoginResponseDto

    @GET("v1/statistics/{id}")
    suspend fun showStatistics(@Path("id") id: String): List<StatisticItemDto>

    @PUT("v1/statistic/{id}")
    suspend fun addStatistic(@Path("id") id: String, @Body body: AddStatisticRequestDto)

    @GET("testConnection")
    suspend fun testConnection(): String

    companion object {
        const val BASE_URL = "http://127.0.0.1.8101/"
        //const val BASE_URL = "http://10.0.2.2:8080/"
    }
}

@Serializable
data class LoginResponseDto (
    val statisticId: String,
)

@Serializable
data class SignUpRequestDto(
    val userName: String,
    val password: String,
)

@Serializable
data class StatisticItemDto (
    val statisticId: String,
)

@Serializable
data class AddStatisticRequestDto (
    val id: String,
    val registered: Boolean,
    val difficulty: String,
    val time: Float,
    val solved: Boolean
)