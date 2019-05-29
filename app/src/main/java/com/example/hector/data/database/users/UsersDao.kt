package com.example.hector.data.database.users

import androidx.room.*
import io.reactivex.Flowable

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM users")
    fun loadAll(): Flowable<List<User>>

    @Query("SELECT * FROM users WHERE id = :id ")
    fun getUserById(id: String): Flowable<User>

    @Delete
    fun delete(user: User)

    @Query(
        "UPDATE users" +
                " SET user_name =:userName, user_year =:userYear, user_height =:userHeight, user_weight=:userWeight " +
                "WHERE id =:userId"
    )
    fun update(userId: Long, userName: String, userYear: Int, userHeight: Float, userWeight: Float)
}