package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticleApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp() {
    ArticleCard(
        image = painterResource(R.drawable.bg_compose_background),
        title = stringResource(R.string.compose_tutorial_title),
        desc = stringResource(R.string.compose_tutorial_desc),
        content = stringResource(R.string.compose_tutorial_content)
    )
}

@Composable
private fun ArticleCard(image: Painter, title: String, desc: String, content: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(painter = image, contentDescription = null)
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier.padding(all = 16.dp)
        )
        Text(
            text = desc,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(all = 16.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ComposeArticleApp()
    }
}