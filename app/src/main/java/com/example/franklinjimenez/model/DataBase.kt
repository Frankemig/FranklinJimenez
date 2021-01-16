package com.example.franklinjimenez

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.*

//Entities
@Entity(tableName = "books")
data class BooksEntity(
    @PrimaryKey val code: Int,
    val author: String,
    val country: String,
    val imageLink: String,
    val language: String,
    val title: String
)

@Entity(tableName = "book_details")
data class BookDetails(
    @PrimaryKey val id: Int,
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

// Interfaz de operaciones
@Dao
interface BookDao {
    @Insert
    suspend fun insert(books: List<BooksEntity>)

    @Query("SELECT * FROM books")
    fun getBooks(): LiveData<List<BooksEntity>>

    @Insert
    suspend fun insertDetail(book: BookDetails)

    @Query("SELECT * FROM book_details WHERE id = :code")
    fun getDetail(code: Int): LiveData<BookDetails>
}

//Cliente Base de Datos
@Database(entities = [BooksEntity::class, BookDetails::class], version = 1)
abstract class BookDataBase : RoomDatabase(){
abstract fun bookDao() : BookDao
}

// Inicialización de la base de datos
class BookApplication : Application() {
    companion object {
        var bookDtabase : BookDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("Room", "onCreate de application")
        bookDtabase = Room.databaseBuilder(this, BookDataBase::class.java, "books_database").build()
    }
}