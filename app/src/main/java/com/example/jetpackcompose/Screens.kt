package com.example.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PreviewNotificationItems() {
//    rememberSaveable
    val count = remember { mutableStateOf(0) }
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)) {
        NotificationCounter(count.value) { count.value++ }
        ShowMessage(count.value)
    }
}

@Composable
fun ShowMessage(count: Int) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "abhi tk k notifications $count", color = Color.Green)
    }
}

@Composable
fun NotificationCounter(count: Int, increment: () -> Unit) {

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Notification shown $count")
        Button(onClick = { increment()
        } ) {
            Text(text = "Click Me")
        }
    }
}


@Composable
fun PreviewRecyclerItems() {
    val item = Items()
    LazyColumn(content = {
        items(item.getCategoryList()){item->
            ShowCategoryItems(item.img,item.title,item.subTitle)
        }
    })
}

@Composable
fun PreviewAllItems(){
    val item = Items()
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        item.getCategoryList().map {item ->
            ShowCategoryItems(item.img,item.title,item.subTitle)
        }
    }

}

@Composable
fun ShowCategoryItems(img: Int, title: String, subTitle: String) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp),
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ){
            Image(imageVector = Icons.Filled.Favorite, colorFilter = ColorFilter.tint(Color.Red),
                contentDescription = "", modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .fillMaxHeight(1f))


           TextDescription(title,subTitle,Modifier.weight(0.8f))
        }
    }
}
// column will act according to modifier
@Composable
fun TextDescription(title: String, subTitle: String, modifier: Modifier) {
    Column(modifier){
        Text(text = title, fontSize = 18.sp,
            fontWeight = FontWeight.Bold, modifier = Modifier.padding(1.dp))
        Text(text = subTitle, modifier = Modifier.padding(1.dp))
    }
}

@Preview
@Composable
fun ShowCategoryItems() {

    val angle = remember { mutableStateOf(0) }

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp),
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .fillMaxSize(1f)
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(1f)
        ){
            Image(imageVector = Icons.Filled.Refresh,
                colorFilter = ColorFilter.tint(Color.Red),
                contentDescription = "", modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .fillMaxHeight(1f)
                    .rotate(((angle.value*10)%360).toFloat()))

        }
    }
    angle.value++
}
