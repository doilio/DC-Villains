package com.doiliomatsinhe.dcvilains.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.doiliomatsinhe.dcvilains.database.VillainsDao
import com.doiliomatsinhe.dcvilains.database.asDomainModel
import com.doiliomatsinhe.dcvilains.model.Villain
import com.doiliomatsinhe.dcvilains.network.ApiService
import com.doiliomatsinhe.dcvilains.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class VillainRepository @Inject constructor(
    private val service: ApiService,
    private val database: VillainsDao
) {

    val villains: LiveData<List<Villain>> =
        Transformations.map(database.getVillainsList()) { it?.asDomainModel() }

    suspend fun refreshVillains() {
        withContext(Dispatchers.IO) {
            try {
                val listOfVillains = service.getVillains()
                database.insertAllVillains(*listOfVillains.asDatabaseModel())
            } catch (e: Exception) {
                Timber.d("Error: ${e.message}")
            }
        }
    }

    suspend fun getVillainById(id: Int): LiveData<Villain> {
        return withContext(Dispatchers.IO) {
            val villain = database.getVillainById(id)

            villain.asDomainModel()
        }
    }
}

