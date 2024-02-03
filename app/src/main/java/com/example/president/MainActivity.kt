package com.example.president

import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.president.ui.theme.PresidentTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "list") {
                composable("list") { PresidentListScreen(navController) }
                composable("detail/{presidentName}") { backStackEntry ->
                    val presidentName = backStackEntry.arguments?.getString("presidentName") ?: ""
                    PresidentDetailScreen(navController, presidentName)
                }
            }
        }
    }
}

@Composable
fun PresidentListScreen(navController: NavController) {
    val presidents = remember { DataProvider.presidents }

    LazyColumn {
        items(presidents) { president ->
            Text(
                text = president.name,
                modifier = Modifier
                    .clickable {
                        navController.navigate("detail/${president.name}")
                    }
                    .padding(16.dp)
            )
        }
    }
}
@Composable
fun PresidentDetailScreen(navController: NavController, presidentName: String) {
    val president = remember { DataProvider.presidents.find { it.name == presidentName } }

    president?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = it.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text("Start Duty: ${it.startDuty}")
            Text("End Duty: ${it.endDuty}")
            Text(text = it.description, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
        }
    } ?: run {
        Text("President not found", fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PresidentTheme {

    }
}