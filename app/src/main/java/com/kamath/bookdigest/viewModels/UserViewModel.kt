package com.kamath.bookdigest.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamath.bookdigest.data.model.Book
import com.kamath.bookdigest.data.model.User
import com.kamath.bookdigest.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository):ViewModel() {
    private val _userList = MutableLiveData<List<User>>()
    val userList:LiveData<List<User>> get() = _userList

    init {
        _userList.value = listOf(
            User("1","km1", listOf("test1"),5, Book("1","000","JackNJill", listOf("sl,sk"),
                listOf("Comedy"),
                "Paperback",
                LocalDate.now(), LocalDate.now(),"new"
            )
            ),

        )
    }
    fun getUserById(userId:String): User?{
        viewModelScope.launch {
            try {
                val user = userRepository.getUserById(userId)
                val updatedUserList = _userList.value?.toMutableList() ?: mutableListOf()
                user.let {
                    // Replace or add the user in the list based on your business logic
                    val existingUserIndex = updatedUserList.indexOfFirst { it.id == user.id }
                    if (existingUserIndex != -1) {
                        updatedUserList[existingUserIndex] = user
                    } else {
                        updatedUserList.add(user)
                    }
                }
                _userList.postValue(updatedUserList)
        }
        catch (e:Exception)
        {
            throw e
            }
        }
       return _userList.value?.find { it.id == userId }
    }
}