package inoxoft.simon.mkulima.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import inoxoft.simon.mkulima.model.Plucker
import kotlinx.coroutines.launch

class PluckerViewModel(private val repository: Repository): ViewModel() {

  fun getPlucker()=repository.getPlucker().asLiveData(viewModelScope.coroutineContext)

  fun upsertPlucker(plucker: Plucker)=viewModelScope.launch {
    repository.upsertPlucker(plucker)
  }

  fun deletePlucker(plucker: Plucker)=viewModelScope.launch {
    repository.deletePlucker(plucker)
  }
}