package com.arturotorralbo.aplicacionvideojuegologros.home.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.arturotorralbo.aplicacionvideojuegologros.models.Achivement
import com.arturotorralbo.aplicacionvideojuegologros.models.achivementsList
import com.arturotorralbo.aplicacionvideojuegologros.navigation.AppScreens
import com.arturotorralbo.aplicacionvideojuegologros.resources.IconBack
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

var idDeleted = 0

@Composable
fun ListItemRow(item: Achivement) {
    val moreInfo = remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            Modifier
                .align(Alignment.Center)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Card(
                Modifier.padding(12.dp), shape = RoundedCornerShape(10.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = item.image),
                    contentDescription = "achivement image",
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
                Row(
                    Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = item.name, modifier = Modifier.weight(1f))
                    IconButton(onClick = { moreInfo.value = !moreInfo.value }) {
                        Icon(
                            if (moreInfo.value) Icons.Default.Remove
                            else Icons.Default.Add, contentDescription = "more info"
                        )
                    }
                }
                if (moreInfo.value) {
                    Column {
                        Row(Modifier.padding(16.dp)) {
                            Text(text = item.difficulty)

                        }
                        Button(onClick = {
                            idDeleted = item.id;

                        }) {
                            Text(text = "Delete")
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel) {
    val isLoading: Boolean by homeViewModel.isLoading.observeAsState(initial = false)

    /*CoroutineScope(Dispatchers.IO).launch {
        val response = try{
            achivementsList()
        }catch (e: Exception){
            null
        }
        if(response!=null){
            if(response.status.isSucsess())

        }
    }*/

    var achievements = remember { mutableStateOf<List<Achivement>?>(null) }

    LaunchedEffect(Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            achievements.value = achivementsList()
        }


    }



    Column(modifier = Modifier.background(Color(0xFF60a8e4))) {
        IconBack(navController = navController)
        Button(
            modifier = Modifier
                .padding(10.dp, 3.dp)
                .fillMaxWidth(),
            onClick = { navController.navigate(route = AppScreens.CreateArchivementsScreen.route) }
        )

        {
            Text(
                text = "Add Archivement",
                color = Color(0xFFFFFFFF)
            )
        }

        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {

            items(achievements.value!!) { item ->
                ListItemRow(item)
                HorizontalDivider(color = Color(0xFF000000))
            }


        }
    }


    /* ConstraintLayout(
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
         }, navController)

         Footer(modifier = Modifier.constrainAs(footer) {
             top.linkTo(body.bottom)
             bottom.linkTo(parent.bottom)
         })
         createVerticalChain(header, body, footer, chainStyle = ChainStyle.SpreadInside)
     }

 */
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
            text = "Home",
            fontSize = 25.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 30.dp, bottom = 10.dp)
        )
    }
}

@Composable
fun Body(modifier: Modifier, navController: NavController) {


    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Row(modifier = modifier.height(100.dp) /*modifier.height(100.dp)*/) {
            Text(
                fontWeight = FontWeight.Bold,
                text = "Create an archivement",
                modifier = Modifier.clickable { navController.navigate(route = AppScreens.CreateArchivementsScreen.route) })
            //esto será un texto que reciba de una api

        }
        Row {
            Text(fontWeight = FontWeight.Bold, text = "Archivements")
            //esto será un extensible puede que ni esté
        }
        /*Row {
            Text(fontWeight = FontWeight.Bold,text = "Habilities")
            //esto será un extensible puede que ni esté
        }
        Row {
            Text(fontWeight = FontWeight.Bold,text = "Map")
            //esto será un extensible puede que ni esté
        }*/


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


/*ConstraintLayout(
    modifier = Modifier
        .fillMaxWidth()
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
fun Body(modifier: Modifier, navController: NavController) {


Column(
    modifier = modifier.padding(16.dp)
) {
    Row(modifier = modifier.height(100.dp) /*modifier.height(100.dp)*/) {
        Text(fontWeight = FontWeight.Bold, text = "Create an archivement", modifier = Modifier.clickable { navController.navigate(route = AppScreens.CreateArchivementsScreen.route) })
        //esto será un texto que reciba de una api

    }
    Row {
        Text(fontWeight = FontWeight.Bold,text = "Archivements")
        //esto será un extensible puede que ni esté
    }
    /*Row {
        Text(fontWeight = FontWeight.Bold,text = "Habilities")
        //esto será un extensible puede que ni esté
    }
    Row {
        Text(fontWeight = FontWeight.Bold,text = "Map")
        //esto será un extensible puede que ni esté
    }*/


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
}*/



