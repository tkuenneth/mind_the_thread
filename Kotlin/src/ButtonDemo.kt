import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.awt.BorderLayout
import java.awt.event.ActionEvent
import javax.swing.*

fun main() {
    SwingUtilities.invokeLater {
        val f: JFrame = BadButtonDemo()
        f.isVisible = true
    }
}

class BadButtonDemo : JFrame(BadButtonDemo::class.java.simpleName) {

    init {
        val centerPanel = JPanel()
        centerPanel.border = BorderFactory.createEmptyBorder(10, 10, 10, 10)
        val result = JLabel()
        result.font = result.font.deriveFont(72f)
        result.text = "---"
        centerPanel.add(result)
        val southPanel = JPanel()
        val button = JButton("Do it")
        button.addActionListener { e: ActionEvent? -> good(result) }
        southPanel.add(button)
        contentPane.add(centerPanel, BorderLayout.CENTER)
        contentPane.add(southPanel, BorderLayout.SOUTH)
        pack()
        setLocationRelativeTo(null)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    }

    fun good(result: JLabel) {
        GlobalScope.launch {
            var i: Int
            do {
                i = (Math.random() * Int.MAX_VALUE).toInt()
                println(i)
            } while (i != Int.MAX_VALUE / 3)
            SwingUtilities.invokeLater { result.text = i.toString() }
        }
    }
}