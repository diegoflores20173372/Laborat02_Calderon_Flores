package com.danp_labs.testcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.danp_labs.testcompose.ui.theme.TestComposeTheme

class ActivityListFood : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ShowListFood()
                }
            }
        }
    }
}

@Composable
fun ShowListFood() {
    val context = LocalContext.current
    val intent = (context as ActivityListFood).intent
    val departmentId = intent.getIntExtra("departmentId", 0)
    val foodList = ArrayList<String>()
    foodList.add("Carne Arrolada, Purtumute, Humitas de Choclo")
    foodList.add("Picante de Cuy, Jaca-Casqui, Pecan-Caldo")
    foodList.add("Papas y Huevos con Uchullachua, La Huatia")
    foodList.add("Chupe De Camarones, Pastel de Papa, Ocopa Arequipeña")
    foodList.add("Patachi, , Puca-Picante")
    foodList.add("Cuy Con Papa, Humitas")
    foodList.add("Chicharrón Cusqueño, Caldo de Cabeza")
    foodList.add("Patachi, Carnero al Palo")
    foodList.add("Mazamorra de Tocosh, Sopa de Cushuro")
    foodList.add("Carapulcra Chinchana, Chupe de Pallares Verdes")
    foodList.add("Cuy Colorado, Papa a la Huancaína")
    foodList.add("Sopa Teóloga, Shambar")
    foodList.add("Arroz con Pato, Humitas")
    foodList.add("Lomo Saltado, Huevo a la Rusa, Pollo a la Brasa")
    foodList.add("Tacacho con Cecina, Inchicapi de Gallina")
    foodList.add("Chapo, Timbuche o Chilcano")
    foodList.add("Picante de Cuy, Moqueguano de Camarones")
    foodList.add("Patasca, Pachamanca")
    foodList.add("Seco de Chavelo, Seco de Cabrito con Tamales Verdes")
    foodList.add("Fricasé, Chayro")
    foodList.add("Apichado de Chancho, Inchik-Api de Gallina")
    foodList.add("Adobo Tacneño, Picante a la Tacneña")
    foodList.add("Ceviche de Pescado, Mariscos")
    foodList.add("Pato a la Ucayalina, Picadillo de Paiche")

    val selectedFoodDepartment = foodList[departmentId - 1]
    val foods = selectedFoodDepartment.split(",")
    println("El código del departamento es: $departmentId")
    Column {
        for(food in foods){
            Text(text = food)
        }
        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }) {
            Text("Volver a elegir un departamento")
        }
    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    TestComposeTheme {
        ShowListFood()
    }
}