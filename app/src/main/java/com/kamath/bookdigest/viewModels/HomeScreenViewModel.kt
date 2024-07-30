package com.kamath.bookdigest.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamath.bookdigest.data.model.BookNeo
import com.kamath.bookdigest.data.model.Genre
import com.kamath.bookdigest.repository.HomeScreenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val homeScreenRepository: HomeScreenRepository):ViewModel(){
 private val TAG = "HOMESCREEN_VIEW_MODEL"

    private val _booksLiveData = MutableLiveData<List<BookNeo?>>()
    val _getBooksLiveData:LiveData<List<BookNeo?>> get() = _booksLiveData

    private val _genresLiveData = MutableLiveData<List<Genre>>()
    val _getGenresLiveData:LiveData<List<Genre>> get() = _genresLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData:LiveData<String> get() = _errorLiveData
    
    fun getAllBooks(){
        viewModelScope.launch { 
            try{
                val homeScreenBooks = homeScreenRepository.getAllBooks()
                homeScreenBooks.let { 
                    try{
                        _booksLiveData.value = it
                    }
                    catch (e:Exception){
                        _errorLiveData.value = "Error ${e.message}"
                    }
                }
            }
            catch (e:Exception){
                Log.e(TAG, "getAllBooks: Issue calling getAllBooks API", )
            }
        }
    }

    fun getGenres(){
        viewModelScope.launch {
            try{
                val genres = homeScreenRepository.getGenres()
                genres.let {
                    try{
                        _genresLiveData.value = it
                    }
                    catch (e:Exception){
                        _errorLiveData.value = "Error ${e.message}"
                    }
                }
            }
            catch (e:Exception){
                Log.e(TAG, "getGenres: Issue calling getGenres API", )
            }
        }
    }
}