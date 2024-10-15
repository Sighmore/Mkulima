package inoxoft.simon.mkulima.viewmodel

import inoxoft.simon.mkulima.model.Plucker
import inoxoft.simon.mkulima.model.PluckerDatabase

class Repository(private val db:PluckerDatabase) {
    suspend fun upsertPlucker(plucker: Plucker){
        db.dao.upsertPlucker(plucker)
    }
    suspend fun deletePlucker(plucker: Plucker){
        db.dao.deletePlucker(plucker)
    }
    fun getPlucker()=db.dao.getPlucker()
}