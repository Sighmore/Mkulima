package inoxoft.simon.mkulima.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Plucker(
    val name: String,
    val kilos: Int,
    val labourAmount: Int,

    @PrimaryKey(autoGenerate = true)
    val pluckerId: Int = 0
)