package `in`.jitinsharma.mydrivecompose.ui.components

import `in`.jitinsharma.mydrivecompose.R
import androidx.compose.foundation.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.asFontFamily
import androidx.compose.ui.text.font.font
import androidx.compose.ui.unit.dp

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
                                        fontFamily = font(R.font.poppins_light).asFontFamily(),
                                        fontWeight = FontWeight.Light
                                    )
                                )
                                append(" 15 Gb")
                            },
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                    Stack {
                        CircularProgressIndicator(
                            modifier = Modifier.preferredWidth(65.dp).preferredHeight(65.dp),
                            progress = 0.5f,
                            strokeWidth = 4.dp,
                            color = MaterialTheme.colors.onPrimary
                        )
                        Text(
                            modifier = Modifier.gravity(Alignment.Center),
                            text = "50%",
                            color = Color.White,
                            style = MaterialTheme.typography.subtitle1
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