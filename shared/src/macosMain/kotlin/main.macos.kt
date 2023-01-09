import platform.AppKit.NSApplication
import platform.AppKit.NSApp
import moe.tlaster.precompose.PreComposeWindow
import com.plauzeware.compose_mp_ios.App

fun main() {
    NSApplication.sharedApplication()
    PreComposeWindow("Minesweeper") {
        App()
    }
    NSApp?.run()
}