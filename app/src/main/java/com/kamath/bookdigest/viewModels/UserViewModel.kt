package com.kamath.bookdigest.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kamath.bookdigest.data.Book
import com.kamath.bookdigest.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor():ViewModel() {
    private val _userList = MutableLiveData<List<User>>()
    val userList:LiveData<List<User>> get() = _userList

    init {
        _userList.value = listOf(
            User("1","km1", listOf("test1"),5, Book("1","000","JackNJill", listOf("sl,sk"),
                listOf("Comedy"),
                "Paperback",
                LocalDate.now(), LocalDate.now(),"new"
            )),

        )
    }
    fun getUserById(userId:String):User?{
       return _userList.value?.find { it.id == userId }
    }
}