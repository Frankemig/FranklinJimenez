package com.example.franklinjimenez

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch
import androidx.lifecycle.*
import androidx.lifecycle.Transformations.map

class MyViewModel : ViewModel() {

    private val repository = Repository()

    private val books = map(repository.book){
entities->entities.map { mapperDBtoBookApi(it) }
    }

    private val selected = MutableLiveData<Book>()

    fun getDetail():LiveData<BookDetail> = repository.bookDetail

    init {
Log.d("ViewModel", "Cargando Información de Libros")
viewModelScope.launch {
    repository.getBooks()
}
    }
fun books() : LiveData<List<Book>> = books

    fun selected(): LiveData<Book> = selected

fun selected (book: Book){
selected.value = book
    viewModelScope.launch {
        repository.getDetail(book.code)
    }
}
}