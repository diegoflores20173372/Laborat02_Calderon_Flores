package com.danp_labs.testcompose

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danp_labs.testcompose.ui.theme.TestComposeTheme

var selectedDepartment: Department? = null

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DepartmentSender("Android")
                }
            }
        }
    }
}

@Composable
fun DepartmentSpinner(departments: List<Department>) {
    var expanded by remember {
        mutableStateOf(false)
    }
    var departmentText by remember {
        mutableStateOf("")
    }
    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(Modifier
            .padding(24.dp)
            .clickable {
                expanded = !expanded
            }
            .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = departmentText, fontSize = 18.sp, modifier = Modifier.padding(end = 8.dp))
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                departments.forEach { department ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        departmentText = department.toString()
                        selectedDepartment = department
                    }) {
                        Text(text = department.toString())
                    }
                }
            }
        }
    }
}

@Composable
fun DepartmentSender(name: String) {
    val departments = ArrayList<Department>()
    departments.add(Department(depId = 1, depName = "Amazonas"))
    departments.add(Department(depId = 2, depName = "Áncash"))
    departments.add(Department(depId = 3, depName = "Apurímac"))
    departments.add(Department(depId = 4, depName = "Arequipa"))
    departments.add(Department(depId = 5, depName = "Ayacucho"))
    departments.add(Department(depId = 6, depName = "Cajamarca"))
    departments.add(Department(depId = 7, depName = "Cusco"))
    departments.add(Department(depId = 8, depName = "Huancavelica"))
    departments.add(Department(depId = 9, depName = "Huánuco"))
    departments.add(Department(depId = 10, depName = "Ica"))
    departments.add(Department(depId = 11, depName = "Junín"))
    departments.add(Department(depId = 12, depName = "La Libertad"))
    departments.add(Department(depId = 13, depName = "Lambayeque"))
    departments.add(Department(depId = 14, depName = "Lima"))
    departments.add(Department(depId = 15, depName = "Loreto"))
    departments.add(Department(depId = 16, depName = "Madre de Dios"))
    departments.add(Department(depId = 17, depName = "Moquegua"))
    departments.add(Department(depId = 18, depName = "Pasco"))
    departments.add(Department(depId = 19, depName = "Piura"))
    departments.add(Department(depId = 20, depName = "Puno"))
    departments.add(Department(depId = 21, depName = "San Martín"))
    departments.add(Department(depId = 22, depName = "Tacna"))
    departments.add(Department(depId = 23, depName = "Tumbes"))
    departments.add(Department(depId = 24, depName = "Ucayali"))
    val context = LocalContext.current
    Column {
        DepartmentSpinner(departments = departments)
        Button(onClick = {
            val intent = Intent(context, ActivityListFood::class.java)
            if (selectedDepartment != null) {
                intent.putExtra("departmentId", selectedDepartment!!.depId)
                context.startActivity(intent)
            } else {
                Toast.makeText(context, "Debe escoger un departamento", Toast.LENGTH_LONG).show()
            }
        }) {
            Text("Buscar Platos")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestComposeTheme {
        DepartmentSender("Android")
    }
}