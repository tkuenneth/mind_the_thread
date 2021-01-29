package java_aktuell

import kotlin.coroutines.*
import kotlinx.coroutines.*
import java.awt.event.*
import javax.swing.*

fun main() {
    SwingUtilities.invokeLater {
        val jframe = MyJFrame()
        jframe.setSize(200, 100)
        jframe.setLocationRelativeTo(null)
        for (i in (1..3)) {
            jframe.launch(CoroutineName(i.toString())) {
                var bool = false
                while (isActive) bool = !bool
                println("${coroutineContext[CoroutineName.Key]?.name} cancelled")
            }
        }
        jframe.isVisible = true
    }
}

class MyJFrame : JFrame("CoroutineScopeDemo"), CoroutineScope {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    init {
        defaultCloseOperation = DO_NOTHING_ON_CLOSE
        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                job.cancel()
                dispose()
            }
        })
    }
}
