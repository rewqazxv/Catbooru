package ink.z31.catbooru.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ink.z31.catbooru.data.database.dao.BooruDao

@Database(version = 1, entities = [Booru::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun booruDao(): BooruDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "database"
            ).build().apply {
                instance = this
            }
        }
    }
}