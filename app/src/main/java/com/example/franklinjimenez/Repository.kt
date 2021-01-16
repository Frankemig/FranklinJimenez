package com.example.franklinjimenez

import android.util.Log
import androidx.lifecycle.MutableLiveData

class Repository {

    private val bookDataBase = BookApplication.bookDtabase!!

    val book = bookDataBase.bookDao().getBooks()

    val bookDetail: MutableLiveData<BookDetail> = MutableLiveData()

    suspend fun getBooks() {
        Log.d("Repository", "get books")
        val response = RetrofitClient.retrofitInstance().getBooks()

        when (response.isSuccessful) {
            true -> response.body()?.let { list ->
                val res = list.map { mapperBookApiToDB(it) }
                bookDataBase.bookDao().insert(res)
            }
            false -> Log.d("Repository", "${response.errorBody()}")
        }
    }

    suspend fun getDetail(code: Int) {
        Log.d("Repository", "getBookDetails")
        val response = RetrofitClient.retrofitInstance().getDetail(code)

        when(response.isSuccessful) {
            true -> response.body().let { bookDetail.value = it }
            false -> Log.d("Repository","${response.errorBody()}")
        }
    }
}