package inoxoft.simon.mkulima

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import inoxoft.simon.mkulima.ui.pages.Labour
import inoxoft.simon.mkulima.ui.pages.Records
import inoxoft.simon.mkulima.viewmodel.PluckerViewModel

@Composable
fun MkulimaNavigation(modifier: Modifier, pluckerViewModel: PluckerViewModel){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "records", builder = {
       composable("labour"){Labour(modifier)}
        composable("records"){Records(modifier,navController)}
    })
}