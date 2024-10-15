package inoxoft.simon.mkulima

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import inoxoft.simon.mkulima.model.PluckerDatabase
import inoxoft.simon.mkulima.ui.theme.MkulimaTheme
import inoxoft.simon.mkulima.viewmodel.PluckerViewModel
import inoxoft.simon.mkulima.viewmodel.Repository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val dbPlucker by lazy {
            Room.databaseBuilder(applicationContext,PluckerDatabase::class.java, name = "plucker.db").build()
        }
        val pluckerViewModel by viewModels<PluckerViewModel> (
            factoryProducer = {
                object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return PluckerViewModel(Repository(dbPlucker)) as T
                    }
                }
            }
        )
        setContent {
            MkulimaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   MkulimaNavigation(modifier= Modifier.padding(innerPadding),pluckerViewModel)
                }
            }
        }
    }
}
