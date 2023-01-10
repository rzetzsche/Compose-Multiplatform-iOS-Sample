import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.application
import com.plauzeware.compose_mp_ios.App
import com.plauzeware.compose_mp_ios.screens.MainScreen
import com.plauzeware.compose_mp_ios.screens.SecondScreen
import moe.tlaster.precompose.PreComposeWindow

fun main() = application {
    PreComposeWindow(onCloseRequest = { exitApplication() }) {
        MaterialTheme {
            App()
        }
    }
}

@Composable
@Preview
fun PreviewMain() {
    MainScreen {  }
}

@Composable
@Preview
fun PreviewSecond() {
    SecondScreen {  }
}