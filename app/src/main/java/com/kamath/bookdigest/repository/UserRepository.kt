package com.kamath.bookdigest.repository

//import com.kamath.bookdigest.data.dao.UserDao
import com.kamath.bookdigest.data.model.User
import com.kamath.bookdigest.data.remoteApi.UserApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(
//    private val userDao: UserDao,
    private val userApi: UserApi
) {

    suspend fun getUserById(userId:String): User {
        return withContext(Dispatchers.IO){
            try {
//                val localUser = userDao.getUserById(userId)
//                if (localUser != null){
//                    return@withContext localUser
//                }
                val remoteUser = userApi.getUserById(userId)
                //also update the local db
                //userDao.insertUser(remoteUser)

                return@withContext remoteUser
            }
            catch (e:Exception){
                throw e
            }
        }
    }
}