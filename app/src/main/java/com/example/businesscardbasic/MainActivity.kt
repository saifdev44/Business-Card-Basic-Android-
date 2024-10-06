package com.example.businesscardbasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardbasic.ui.theme.BusinessCardBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardBasicTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCardScreen(
                        name = "Jennifer Doe",
                        title = "Android Developer Extraordinary",
                        phone = "+11 (22) 444 555 666",
                        shareLink = "@AndroidDev",
                        emailId = "jen.doe@android.com",
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(name: String, title: String, phone: String, shareLink: String, emailId: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.android_logo)

    Column(modifier = modifier
        .fillMaxSize()
        .background(color = Color(0xFFD2E8D4)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Spacer(modifier = Modifier.weight(1f))
        //Center content start
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) { //Android logo start
            Box(modifier = modifier
                .background(color = Color(0xFF073042))
                .height(120.dp)
                .width(120.dp)
            ){
                Image(painter = image, contentDescription = null)
            }
            //Android logo end

            Text(
                text = name,
                fontSize = 32.sp,
                color = Color.Black
            )

            Text(
                text = title,
                color = Color(0xFF006C38),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
        //Center content end

        Column(
            modifier = modifier
                .padding(bottom = 200.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            ContactViewer(icon = Icons.Default.Call, contactInfo = phone)
            ContactViewer(icon = Icons.Default.Share, contactInfo = shareLink)
            ContactViewer(icon = Icons.Default.Email, contactInfo = emailId)
        }
    }
}

@Composable
fun ContactViewer(icon: ImageVector, contactInfo: String, modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(bottom = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = modifier.size(24.dp),
            tint = Color(0xFF006C38),
        )
        Spacer(modifier = modifier.width(16.dp))
        Text(
            text = contactInfo,
            color = Color.Black
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardBasicTheme {
        BusinessCardScreen(
            name = "Jennifer Doe",
            title = "Android Developer Extraordinary",
            phone = "+11 (22) 444 555 666",
            shareLink = "@AndroidDev",
            emailId = "jen.doe@android.com"
        )
    }
}