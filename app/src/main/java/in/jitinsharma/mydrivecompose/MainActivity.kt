package `in`.jitinsharma.mydrivecompose

import `in`.jitinsharma.mydrivecompose.ui.MyDriveComposeTheme
import `in`.jitinsharma.mydrivecompose.ui.components.FolderList
import `in`.jitinsharma.mydrivecompose.ui.components.Header
import `in`.jitinsharma.mydrivecompose.ui.components.InputField
import `in`.jitinsharma.mydrivecompose.ui.components.StorageCard
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ambientOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkModeState = remember { mutableStateOf(false) }
            MyDriveComposeTheme(darkTheme = darkModeState) {
                DriveScreen {
                    darkModeState.value = darkModeState.value.not()
                }
            }
        }
    }
}

@Composable
fun DriveScreen(onOptionClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        Column {
            Header { onOptionClick.invoke() }
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            InputField()
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            StorageCard()
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            FolderList()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyDriveComposeTheme(mutableStateOf(false)) {
        DriveScreen { }
    }
}