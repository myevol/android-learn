package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    BusinessCard(
        avatar = painterResource(id = R.drawable.wechatimg125),
        name = stringResource(R.string.name),
        title = stringResource(R.string.title),
        phone = stringResource(R.string.phone),
        address = stringResource(R.string.address),
        email = stringResource(R.string.email)
    )
}

@Composable
fun BusinessCard(
    avatar: Painter,
    name: String,
    title: String,
    phone: String,
    address: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().background(color = Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Box() {
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = avatar, contentDescription = null)
                Text(
                    text = name,
                    modifier = modifier.padding(top = 10.dp),
                    color = Color.White,
                    fontSize = 24.sp
                )
                Text(
                    text = title,
                    modifier = modifier.padding(top = 6.dp),
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
        InfoList(phone = phone, address = address, email = email)
    }
}

@Composable
fun InfoList(
    phone: String,
    email: String,
    address: String,
    modifier: Modifier = Modifier
) {
    Column() {
        InfoItem(
            icon = Icons.Rounded.Place,
            info = address
        )
        InfoItem(
            icon = Icons.Rounded.Email,
            info = email
        )
        InfoItem(
            icon = Icons.Rounded.Phone,
            info = phone
        )
    }
}

@Composable
fun InfoItem(icon: ImageVector, info: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(top = 12.dp)
    ) {
        Icon(imageVector = icon, tint = Color.White, contentDescription = null)
        Text(
            text = info,
            modifier = modifier.padding(start = 6.dp),
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}