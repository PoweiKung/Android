package com.example.deron.t5_Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.deron.t5_Room.dao.UserDAO
import com.example.deron.t5_Room.table.RoomUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Database(entities = [RoomUser::class], version = 1, exportSchema = false)
abstract class DB : RoomDatabase() {
    abstract fun userDao(): UserDAO
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DB {
        return Room.databaseBuilder(
            context,
            DB::class.java,
            "AppDB"
        ).build()
    }
    @Provides
    fun provideUserDao(db: DB): UserDAO {
        return db.userDao()
    }
}