package com.example.franklinjimenez

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/"

interface BooksApi {

    @GET("books")
    suspend fun getBooks(): Response<List<Book>>

    @GET("bookDetail/{code}")
    suspend fun getDetail(@Path("code") code: Int): Response<BookDetail>
}

class RetrofitClient{
    companion object {
        fun retrofitInstance(): BooksApi {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            return retrofit.create(BooksApi::class.java)
        }
    }
}
//Pojos
data class Book(
    val code: Int,
    val author: String,
    val country: String,
    val imageLink: String,
    val language: String,
    val title: String
)

data class BookDetail(
    val id: Int,
    val author: String,
    val country: String,
    val imageLink: String,
    val language: String,
    val link: String,
    val pages: String,
    val title: String,
    val year: String,
    val price: String,
    val lastPrice: String,
    val delivery: Boolean
)
