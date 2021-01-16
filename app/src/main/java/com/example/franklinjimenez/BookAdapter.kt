package com.example.franklinjimenez

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.franklinjimenez.databinding.BookItemBinding
import com.squareup.picasso.Picasso

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookVH>() {
    private var bookList = listOf<Book>()

    private val selectedItem = MutableLiveData<Book>()

    fun selectedItem(): LiveData<Book> = selectedItem

    class BookVH(val binding: BookItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            binding.tvTitle.text = book.title
            binding.tvNombreAutor.text = book.author
            binding.tvPais.text = book.country
            binding.tvIdioma.text = book.language

            try {
                Picasso.get().load(book.imageLink).resize(90, 120).into(binding.imageView)
            } catch (e: Exception) {

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookVH {
        val binding = BookItemBinding.inflate(LayoutInflater.from(parent.context))
        return BookVH(binding)

    }

    override fun onBindViewHolder(holder: BookVH, position: Int) {

        val book = bookList[position]
        holder.bind(book)

        holder.itemView.setOnClickListener {
            selectedItem.value = book
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    fun update(pBookList: List<Book>) {
        bookList = pBookList
        notifyDataSetChanged()

    }
}