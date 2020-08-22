package `in`.jitinsharma.mydrivecompose.ui.components

import `in`.jitinsharma.mydrivecompose.R
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.RippleIndication
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
fun Header(onOptionClick: () -> Unit) {
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
            modifier = Modifier
                .preferredSize(16.dp)
                .indication(
                    interactionState = InteractionState(),
                    indication = RippleIndication()
                )
                .clickable(onClick = { onOptionClick.invoke() })
        )
    }
}