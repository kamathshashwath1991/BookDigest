package com.kamath.bookdigest.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamath.bookdigest.data.model.BookDetailsResponse
import com.kamath.bookdigest.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(private val bookRepository: BookRepository):ViewModel(){

    private val TAG = "BOOKS_VIEW_MODEL"
    private val _bookDetailsLiveData = MutableLiveData<BookDetailsResponse?>()
    val bookDetailLiveData: LiveData<BookDetailsResponse?> get() = _bookDetailsLiveData
    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData:LiveData<String> get() = _errorLiveData

    fun searchBookByIsbn(isbn:String){
        viewModelScope.launch {
            try {
                val bookDetails = bookRepository.getBookDetails(isbn)
                bookDetails.let {
                    try{
                        _bookDetailsLiveData.value = it
                    }
                    catch (e:Exception){
                        _errorLiveData.value = "Error ${e.message}"
                    }
                }
            }catch (e:Exception){
                Log.e(TAG, "searchBookByIsbn: Issue with calling Books API ${e.message}")
            }
        }
    }
/*
    fun createBook(){
        viewModelScope.launch {
            try{
                val book = BookNeo(
                    title = "To Kill a Mockingbird",
                    author = "Harper Lee",
                    year = "1960",
                    genre = "Fiction",
                    pages = "281",
                    isbn = "9780061120084",
                    publishedDate = "1960-07-11",
                    originalCost = "12.95"
                )
                bookRepository.createBook(book).let { Log.d(TAG, "createBook: Book is posted!") }
            }catch (e:Exception){
                Log.e(TAG, "createBook: Issue while creating book" )
            }
        }
    }

 */
}