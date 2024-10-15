package inoxoft.simon.mkulima.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Records(modifier: Modifier, navController: NavHostController){
    Column(modifier) {
        AppBar(modifier)
        EntryPage(modifier.weight(1F))
        BottomBar(modifier,navController)
    }
}

@Composable
fun EntryPage(modifier: Modifier) {
    Column(modifier) {
        var plucker by remember {
            mutableStateOf("")
        }

        var pluckerKilo by remember {
            mutableStateOf("")
        }

        Row (
            modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
            ){

            OutlinedTextField(modifier = Modifier.width(170.dp),
                value =plucker ,
                onValueChange = {plucker=it},
                label = {
                    Text(text = "Plucker Name")
                }
            )
            Spacer(modifier = Modifier.width(10.dp))

            OutlinedTextField(modifier = Modifier.width(100.dp),
                value =pluckerKilo ,
                onValueChange = {pluckerKilo=it},
                label = {
                    Text(text = "Kilos")
                }
            )

        }
        Row (
            modifier
                .fillMaxWidth()
                .padding(20.dp), horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Button(onClick = { /*TODO*/ }
                ) {
                Text(text = "KTDA")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "TET/UNI/CML")
            }
        }

//        Row (modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
//            Text(text = "Plucker name")
//            Text(text = "Kilos")
//            Text(text = "Amount")
//        }
//        LazyColumn {
//
//        }
    }
}


@Composable
fun AppBar(modifier: Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer),
        horizontalArrangement = Arrangement.Center){
        Text(modifier = Modifier.padding(10.dp),
            text = "Mkulima App", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun BottomBar(modifier: Modifier, navController: NavHostController) {

    Row(
        modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
        Column {
            IconButton(onClick = { navController.navigate("records") }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Add Record")
            }
            Text(modifier = Modifier.padding(5.dp), text = "Plucker")
        }
        Column {
            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Add Record")
            }
            Text(modifier = Modifier.padding(5.dp), text = "Farmers")
        }
        Column {
            IconButton(onClick = { navController.navigate("labour") }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Labour pay")
            }
            Text(modifier = Modifier.padding(5.dp),text = "Records")
        }
    }

}


