package `in`.jitinsharma.mydrivecompose

import `in`.jitinsharma.mydrivecompose.ui.MyDriveComposeTheme
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
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
            val darkModeState = remember { mutableStateOf(false) }
            MyDriveComposeTheme(darkTheme = darkModeState) {
                DriveScreen(darkModeState)
            }
        }
    }
}

@Composable
fun DriveScreen(darkTheme: MutableState<Boolean>) {
    Box(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        Column {
            Header(darkTheme)
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            InputField()
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            StorageCard()
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            FolderList()
        }
    }
}

sealed class FolderListItem
data class TitleItem(val name: String = "My Folders") : FolderListItem()
data class ContentItem(
    val name: String,
    val count: String,
    val size: String
) : FolderListItem()

@Composable
fun FolderList() {
    Card(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(topLeft = 16.dp, topRight = 16.dp)
    ) {
        LazyColumnFor(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
            items = listOf(
                TitleItem(),
                ContentItem(name = "E-Learning Web Design", count = "12 items", size = "10 Mb"),
                ContentItem(name = "Online Shop Web Design", count = "22 items", size = "23 Mb"),
                ContentItem(name = "Analytical Dashboard", count = "40 items", size = "33 Mb"),
                ContentItem(name = "Creative Landing Page", count = "6 items", size = "5 Mb"),
                ContentItem(name = "Hospital Dashboard", count = "24 items", size = "27 Mb"),
                ContentItem(name = "Web UI kit", count = "22 items", size = "23 Mb")
            )
        ) { item ->
            when (item) {
                is TitleItem -> {
                    Row(
                        modifier = Modifier.padding(start = 16.dp, bottom = 16.dp, end = 8.dp)
                            .fillParentMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.name,
                            color = MaterialTheme.colors.onBackground
                        )
                        Icon(
                            asset = vectorResource(id = R.drawable.ic_square_menu),
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                }
                is ContentItem -> {
                    Row {
                        Image(asset = vectorResource(id = R.drawable.ic_folder_big))
                        Spacer(modifier = Modifier.preferredWidth(8.dp))

                        Column(
                            modifier = Modifier.gravity(Alignment.CenterVertically)
                        ) {
                            Text(
                                text = item.name,
                                color = MaterialTheme.colors.onBackground
                            )
                            Text(
                                text = "${item.count}  -  ${item.size}",
                                color = MaterialTheme.colors.onBackground
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StorageCard() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        shape = RoundedCornerShape(24.dp),
        color = MaterialTheme.colors.primary
    ) {
        Stack {
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
                            color = MaterialTheme.colors.onPrimary
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
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                    Stack {
                        Image(asset = vectorResource(id = R.drawable.bg_circle))
                        Text(
                            modifier = Modifier.gravity(Alignment.Center),
                            text = "50%",
                            color = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.preferredHeight(32.dp))
            }
            Box(
                modifier = Modifier.gravity(Alignment.TopEnd).preferredHeight(56.dp)
                    .preferredWidth(56.dp),
                gravity = Alignment.Center,
                shape = RoundedCornerShape(
                    topLeft = 0.dp,
                    bottomLeft = 24.dp,
                    bottomRight = 0.dp,
                    topRight = 24.dp
                ),
                backgroundColor = Color(0xFF405DB5)
            ) {
                Image(
                    asset = vectorResource(id = R.drawable.ic_left)
                )
            }
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
            backgroundColor = MaterialTheme.colors.background
        ) {
            Row(modifier = Modifier.padding(12.dp)) {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_search_icon),
                    tint = MaterialTheme.colors.onBackground
                )
                Spacer(modifier = Modifier.preferredWidth(16.dp))
                Text(
                    text = "Search Files",
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
        Spacer(modifier = Modifier.preferredWidth(16.dp))
    }
}

@Composable
fun Header(darkTheme: MutableState<Boolean>) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            asset = vectorResource(id = R.drawable.icon_menu),
            modifier = Modifier.preferredSize(16.dp),
            tint = MaterialTheme.colors.onSecondary
        )
        Text(
            text = "My Drive",
            color = MaterialTheme.colors.onSecondary
        )
        Icon(
            asset = vectorResource(id = R.drawable.ic_options),
            tint = MaterialTheme.colors.onSecondary,
            modifier = Modifier.preferredSize(16.dp)
                .clickable(onClick = {
                    darkTheme.value = darkTheme.value.not()
                })
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyDriveComposeTheme(mutableStateOf(false)) {
        DriveScreen(mutableStateOf(false))
    }
}