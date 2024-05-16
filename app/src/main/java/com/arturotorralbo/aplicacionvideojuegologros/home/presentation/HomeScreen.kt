package com.arturotorralbo.aplicacionvideojuegologros.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.arturotorralbo.aplicacionvideojuegologros.resources.IconBack

@Composable
fun HomeScreen(navController: NavController) {



    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
        })

        Footer(modifier = Modifier.constrainAs(footer) {
            top.linkTo(body.bottom)
            bottom.linkTo(parent.bottom)
        })
        createVerticalChain(header, body, footer, chainStyle = ChainStyle.SpreadInside)
    }


}

@Composable
fun Header(modifier: Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IconBack(navController = navController)
        Text(
            text = "Home \n those are all placeholders",
            fontSize = 25.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 30.dp, bottom = 10.dp)
        )
    }
}

@Composable
fun Body(modifier: Modifier) {


    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Row(modifier = modifier.height(100.dp)) {
            Text(fontWeight = FontWeight.Bold, text = "History")
            //esto será un extensible

        }
        Row {
            Text(fontWeight = FontWeight.Bold,text = "Characters and enemies")
            //esto será un extensible
        }
        Row {
            Text(fontWeight = FontWeight.Bold,text = "Habilities")
            //esto será un extensible
        }
        Row {
            Text(fontWeight = FontWeight.Bold,text = "map")
            //esto será un extensible
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
        /*Button(
            onClick = { navController.navigate(Routes.PaymentGatewayScreenRoute.route) },
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("RESERVE")
        }

        Button(
            onClick = { navController.navigate(Routes.SignInScreenRoute.route) },
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("LOGIN")
        }*/
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

        //HomeScreen()


}
