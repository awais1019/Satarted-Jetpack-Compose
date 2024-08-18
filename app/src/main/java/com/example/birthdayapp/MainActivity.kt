package com.example.birthdayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdayapp.ui.theme.BirthdayAppTheme
import com.example.birthdayapp.ui.theme.color1
import com.example.birthdayapp.ui.theme.color2
import com.example.birthdayapp.ui.theme.color3
import com.example.birthdayapp.ui.theme.color4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun DisplayImg(img:Int)
{
    Image(
        painter = painterResource(id = img), contentDescription = "Title")
}

@Composable
fun DisplayContent(title:String,paragraph1:String,paragraph2: String) {

    Column {
        Text(
            text = title, fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = paragraph1,
            modifier = Modifier.padding(16.dp,0.dp),
                    textAlign = TextAlign.Justify,

            )
        Text(
            text = paragraph2,
            modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Justify,
        )
    }
}

@Composable
fun ComposeArticle(modifier: Modifier,img: Int,title: String,paragraph1: String,paragraph2: String)
{
        Column {
            DisplayImg(img = R.drawable.bg_compose_background)
            DisplayContent(title = title, paragraph1 = paragraph1, paragraph2 = paragraph2)
        }
    
}

@Preview(showBackground = true,name="task1")
@Composable
fun PreviewCompose()
{
   Task1()
}
@Composable
fun Task1(){
    ComposeArticle(
        modifier = Modifier
            .fillMaxSize(),
        img = R.drawable.bg_compose_background,
        title = stringResource(id = R.string.title),
        paragraph1 = stringResource(id =R.string.first_paragraph),
        paragraph2 = stringResource(id = R.string.second_paragraph)
    )
}

@Composable
fun TaskManager(img:Int,heading1:String,heading2: String,modifier: Modifier=Modifier)
{
    Column (verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally
    , modifier = modifier){
        Image(painter = painterResource(id = img), contentDescription =null )
        Text(text = heading1, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top=24.dp, bottom = 8.dp))
        Text(text = heading2, fontSize = 16.sp)
    }
}
@Composable
fun CallTaskManger()
{
     TaskManager(img = R.drawable.ic_task_completed,
         heading1 = stringResource(id = R.string.heading1),
         heading2 = stringResource(id = R.string.heading2),
         modifier = Modifier.fillMaxSize())
}

/*@Preview(showBackground = true, name ="task2")
@Composable
fun Task2()
{
    TaskManager(img = R.drawable.ic_task_completed,
        heading1 = stringResource(id = R.string.heading1),
        heading2 = stringResource(id = R.string.heading2),
        modifier = Modifier.fillMaxSize())
}*/
@Composable
fun ShowCard(
      title: String,
      content:String,
      color:Color,
      modifier: Modifier=Modifier
)
{
         Column(modifier= modifier.fillMaxSize()
             .background(color)
             .padding(16.dp),verticalArrangement = Arrangement.Center,
             horizontalAlignment =Alignment.CenterHorizontally, ){
             Text(text = title,modifier=Modifier.padding(bottom = 16.dp),
                 fontWeight = FontWeight.Bold
             )
             Text(text = content, textAlign = TextAlign.Justify)
         }

}

@Composable
fun CallCard()
{

    Column(modifier =Modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            ShowCard(title = stringResource(id = R.string.text_composable) ,
                content = stringResource(id = R.string.text_composable_detail) ,
                color = color1,
                modifier = Modifier.weight(1f))

            ShowCard(title = stringResource(id = R.string.img_composable) ,
                content = stringResource(id = R.string.img_composable_detail) ,
                color = color2,
                modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.weight(1f)){
            ShowCard(title = stringResource(id = R.string.row_composable) ,
                content = stringResource(id = R.string.row_composable_detail) ,
                color = color3,
                modifier = Modifier.weight(1f))
            ShowCard(title = stringResource(id = R.string.column_composable) ,
                content = stringResource(id = R.string.column_composable_detail) ,
                color = color4,
                modifier = Modifier.weight(1f))
        }
    }

}

@Preview(showBackground = true, name = "task3", showSystemUi = true)
@Composable
fun  Task3()
{
    CallCard()
}