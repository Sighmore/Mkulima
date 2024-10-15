package inoxoft.simon.mkulima.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface PluckerDao {

    @Upsert
    suspend fun upsertPlucker(plucker:Plucker)

    @Delete
    suspend fun  deletePlucker(plucker: Plucker)

    @Query("SELECT * FROM plucker")
    fun getPlucker(): Flow<List<Plucker>>

}