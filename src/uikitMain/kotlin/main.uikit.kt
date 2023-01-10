import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.ui.main.defaultUIKitMain
import com.plauzeware.compose_mp_ios.App
import moe.tlaster.precompose.PreComposeApplication

fun main() {
    defaultUIKitMain("SampleApp", PreComposeApplication("SampleApp") {
        Column {
            Box(modifier = Modifier.height(30.dp))
            App()
        }
    })
}