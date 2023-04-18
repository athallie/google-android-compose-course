package com.example.composebusinesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebusinesscardapp.ui.theme.ComposeBusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(
                        stringResource(R.string.name),
                        stringResource(R.string.occupation)
                    )
                }
            }
        }
    }
}

@Composable
fun LogoWithText(name: String, occupation: String, modifier: Modifier = Modifier) {
    val logo = painterResource(R.drawable.android_logo)
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = logo,
            contentDescription = "Android Logo",
            contentScale = ContentScale.Inside,
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = name,
            style = TextStyle(
                fontSize = 60.sp,
                fontWeight = FontWeight.Light,
                color = Color.White
            )
        )
        Text(
            text = occupation,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.hsv(147f, 0.72f, 0.86f)
            )
        )
    }
}

@Composable
fun App(name: String, occupation: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(color = Color.hsv(198f, 0.89f, 0.26f)),
    ) {
        LogoWithText(
            name,
            occupation,
            Modifier.align(Alignment.Center)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AppPreview() {
    ComposeBusinessCardAppTheme {
        App(
            stringResource(R.string.name),
            stringResource(R.string.occupation)
        )
    }
}