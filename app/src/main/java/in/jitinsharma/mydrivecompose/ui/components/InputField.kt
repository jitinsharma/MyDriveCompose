package `in`.jitinsharma.mydrivecompose.ui.components

import `in`.jitinsharma.mydrivecompose.R
import androidx.compose.foundation.Box
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.drawLayer
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
fun InputField() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.preferredWidth(16.dp))
        Box(
            modifier = Modifier
                .weight(0.8f)
                .preferredHeight(48.dp)
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
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
        Spacer(modifier = Modifier.preferredWidth(16.dp))
    }
}