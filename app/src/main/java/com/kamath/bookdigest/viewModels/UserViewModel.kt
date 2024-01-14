package com.kamath.bookdigest.viewModels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kamath.bookdigest.data.Book
import com.kamath.bookdigest.data.User
import java.time.LocalDate
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
class UserViewModel:ViewModel() {
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
}