package com.arturotorralbo.aplicacionvideojuegologros.createArchivement.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.arturotorralbo.aplicacionvideojuegologros.resources.IconBack

@Composable
fun CreateArchivementScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF60a8e4))
            .verticalScroll(rememberScrollState())
    ) {
        val (header, body, footer) = createRefs()
        Header(modifier = Modifier.constrainAs(header) {
            top.linkTo(parent.top)
            bottom.linkTo(body.top)

        }, navController)

        Body(modifier = Modifier.constrainAs(body) {
            top.linkTo(header.bottom)
            bottom.linkTo(footer.top)
        }, navController)

        Footer(modifier = Modifier.constrainAs(footer) {
            top.linkTo(body.bottom)
            bottom.linkTo(parent.bottom)
        })
        createVerticalChain(header, body, footer, chainStyle = ChainStyle.SpreadInside)
    }


}

@Composable
fun Header(modifier: Modifier, navController: NavController) {
    IconBack(navController = navController)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = "Create an archivement",
            fontSize = 25.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 30.dp, bottom = 10.dp)
        )
    }
}

@Composable
fun Body(modifier: Modifier, navController: NavController) {
    var textName = remember { mutableStateOf(TextFieldValue("")) }
    var textDificulty = remember { mutableStateOf(TextFieldValue("")) }
    var textDescription = remember { mutableStateOf(TextFieldValue("")) }
    var textImage = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.White)
                .fillMaxSize()
        ) {
            Column(
                Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
            ) {
                Card(shape = RoundedCornerShape(10.dp)) {


                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            fontWeight = FontWeight.Bold,
                            text = "name:",
                            modifier = Modifier.weight(1f)
                        )
                        TextField(
                            value = textName.value,
                            onValueChange = { newTextName -> textName.value = newTextName },
                            modifier = Modifier.width(270.dp)
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.White)
                .fillMaxSize()

        ) {
            Column(
                Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
            ) {
                Card(shape = RoundedCornerShape(10.dp), modifier = Modifier.fillMaxWidth()) {


                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            fontWeight = FontWeight.Bold,
                            text = "dificulty:",
                            modifier = Modifier.weight(1f)
                        )
                        TextField(
                            value = textDificulty.value,
                            onValueChange = { newTextDificulty ->
                                textDificulty.value = newTextDificulty
                            },
                            modifier = Modifier.width(270.dp)

                        )
                    }
                }
            }
        }
        Box(
                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.White)
                    .fillMaxSize()
                ) {
            Column(
                Modifier
                    .align(Alignment.Center)

                    .fillMaxWidth()
            ) {
                Card(shape = RoundedCornerShape(10.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            fontWeight = FontWeight.Bold,
                            text = "desc:",
                            modifier = Modifier.weight(1f)
                        )
                        TextField(
                            value = textDescription.value,
                            onValueChange = { newTextDescription ->
                                textDescription.value = newTextDescription
                            },
                            modifier = Modifier.width(270.dp)

                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.White)
                .fillMaxSize()
        ) {
            Column(
                Modifier
                    .align(Alignment.Center)

                    .fillMaxWidth()
            ) {
                Card(shape = RoundedCornerShape(10.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            fontWeight = FontWeight.Bold,
                            text = "image:",
                            modifier = Modifier.weight(1f)
                        )
                        TextField(
                            value = textImage.value,
                            onValueChange = { newTextImage ->
                                textImage.value = newTextImage
                            },
                            modifier = Modifier.width(270.dp)

                        )
                    }
                }
            }
        }
            Row {

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Text(fontWeight = FontWeight.Bold, text = "Add")
                }


            }


        }
    }

    @Composable
    fun Footer(modifier: Modifier) {


        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

        }
    }

