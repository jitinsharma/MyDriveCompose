package `in`.jitinsharma.mydrivecompose.ui.components

import `in`.jitinsharma.mydrivecompose.R
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
fun FolderList() {
    Card(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(topLeft = 16.dp, topRight = 16.dp)
    ) {
        LazyColumnFor(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
            items = items
        ) { item ->
            when (item) {
                is TitleItem -> {
                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 16.dp, end = 8.dp)
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
                                color = MaterialTheme.colors.onBackground,
                                style = MaterialTheme.typography.caption
                            )
                        }
                    }
                }
            }
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


val items = listOf(
    TitleItem(),
    ContentItem(name = "E-Learning Web Design", count = "12 items", size = "10 Mb"),
    ContentItem(name = "Online Shop Web Design", count = "22 items", size = "23 Mb"),
    ContentItem(name = "Analytical Dashboard", count = "40 items", size = "33 Mb"),
    ContentItem(name = "Creative Landing Page", count = "6 items", size = "5 Mb"),
    ContentItem(name = "Hospital Dashboard", count = "24 items", size = "27 Mb"),
    ContentItem(name = "Web UI kit", count = "22 items", size = "23 Mb")
)
