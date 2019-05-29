package com.example.hector.data.local.users

import androidx.room.*
import io.reactivex.Flowable

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE id = :id ")
    fun getUserById(id: Long): User

    @Delete
    fun delete(user: User)

    @Query(
        "UPDATE users" +
                " SET user_name =:userName, user_year =:userYear, user_height =:userHeight, user_step=:userStep " +
                "WHERE id =:userId"
    )
    fun update(userId: Long, userName: String, userYear: Int, userHeight: Float, userStep: Float)
}