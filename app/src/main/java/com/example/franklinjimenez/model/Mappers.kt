package com.example.franklinjimenez

fun mapperBookApiToDB(book: Book): BooksEntity{
return BooksEntity(book.code, book.author, book.country, book.imageLink, book.language, book.title)
}

fun mapperDBtoBookApi(entity: BooksEntity) : Book{
    return Book(entity.code, entity.author, entity.country, entity.imageLink, entity.language, entity.title)
}