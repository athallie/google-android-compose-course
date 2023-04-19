package com.example.composebusinesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
                        stringResource(R.string.occupation),
                        stringResource(R.string.icon_1_text),
                        stringResource(R.string.icon_2_text),
                        stringResource(R.string.icon_3_text)
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
                color = Color(0xFF3DDB84)
            )
        )
    }
}
@Composable
fun IconWithText(
    icon: ImageVector,
    iconDesc: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconDesc,
            tint = Color(0xFF3DDB84),
            modifier = Modifier.padding(
                start = 45.dp,
                end = 23.dp
            )
        )
        Text(
            text = text,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                color = Color.White
            )
        )
    }
}

@Composable
fun App(
    name: String,
    occupation: String,
    phoneNumber: String,
    socialMediaUserName: String,
    email: String,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(color = Color(0xFF073142)),
        verticalArrangement = Arrangement.Center
    ) {
        LogoWithText(
            name,
            occupation,
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 100.dp)
        )
    }
    Column(
        modifier = Modifier
            .padding(
                bottom = 50.dp
            ),
        verticalArrangement = Arrangement.Bottom
    ) {
        Divider(color = Color.Gray, thickness = 1.dp)
        Spacer(modifier.height(6.5.dp))
        IconWithText(
            icon = Icons.Filled.Phone,
            iconDesc = stringResource(R.string.icon_1_name),
            text = phoneNumber
        )
        Spacer(modifier.height(6.5.dp))
        Divider(color = Color.Gray, thickness = 1.dp)
        Spacer(Modifier.height(6.5.dp))
        IconWithText(
            icon = Icons.Filled.Share,
            iconDesc = stringResource(R.string.icon_2_name),
            text = socialMediaUserName
        )
        Spacer(modifier.height(6.5.dp))
        Divider(color = Color.Gray, thickness = 1.dp)
        Spacer(Modifier.height(6.5.dp))
        IconWithText(
            icon = Icons.Filled.Email,
            iconDesc = stringResource(R.string.icon_3_name),
            text = email
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
            stringResource(R.string.occupation),
            stringResource(R.string.icon_1_text),
            stringResource(R.string.icon_2_text),
            stringResource(R.string.icon_3_text)
        )
    }
}