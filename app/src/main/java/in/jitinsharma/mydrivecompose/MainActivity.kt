package `in`.jitinsharma.mydrivecompose

import `in`.jitinsharma.mydrivecompose.ui.MyDriveComposeTheme
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Box
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDriveComposeTheme {
                DriveScreen()
            }
        }
    }
}

@Composable
fun DriveScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color(0xFFF2F5F8)
    ) {
        Column {
            Header()
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            InputField()
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            StorageCard()
        }
    }
}

@Composable
fun StorageCard() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        shape = RoundedCornerShape(24.dp),
        color = Color(0xFF4378DB)
    ) {
        Column(modifier = Modifier.padding(start = 32.dp)) {
            Spacer(modifier = Modifier.preferredHeight(32.dp))
            Image(asset = vectorResource(id = R.drawable.drive_icon))
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalGravity = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Free Storage",
                        style = MaterialTheme.typography.h6,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.preferredHeight(8.dp))
                    Text(
                        text = annotatedString {
                            pushStyle(
                                SpanStyle(
                                    fontWeight = FontWeight.Medium
                                )
                            )
                            append("7.5Gb /")
                            pop()
                            pushStyle(
                                SpanStyle(
                                    fontWeight = FontWeight.Light
                                )
                            )
                            append(" 15 Gb")
                        },
                        style = MaterialTheme.typography.h6,
                        color = Color.White
                    )
                }
                CircularProgressIndicator(
                    progress = 0.5f,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.preferredHeight(32.dp))
        }
    }
}

@Composable
fun InputField() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.preferredWidth(16.dp))
        Box(
            modifier = Modifier.weight(0.8f).preferredHeight(48.dp)
                .drawShadow(elevation = 4.dp, shape = RoundedCornerShape(24.dp)),
            shape = RoundedCornerShape(24.dp),
            backgroundColor = Color.White
        ) {
            Row(modifier = Modifier.padding(12.dp)) {
                Icon(asset = vectorResource(id = R.drawable.ic_search_icon))
                Spacer(modifier = Modifier.preferredWidth(16.dp))
                Text(text = "Search Files", color = Color.Black)
            }
        }
        Spacer(modifier = Modifier.preferredWidth(16.dp))
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            asset = vectorResource(id = R.drawable.icon_menu),
            modifier = Modifier.preferredSize(16.dp)
        )
        Text(text = "My Drive")
        Icon(
            asset = imageResource(id = R.drawable.avatar),
            modifier = Modifier.preferredSize(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyDriveComposeTheme {
        DriveScreen()
    }
}