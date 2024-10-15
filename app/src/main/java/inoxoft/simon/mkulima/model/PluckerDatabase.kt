package inoxoft.simon.mkulima.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Plucker::class], version = 1)
abstract class PluckerDatabase: RoomDatabase(){
    abstract val dao: PluckerDao
}
