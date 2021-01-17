import java.awt.BorderLayout
import java.awt.EventQueue.invokeLater
import java.net.URL
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import kotlin.concurrent.thread

fun main() {
    invokeLater {
        val frame = JFrame("Better")
        val label = JLabel("Not clicked")
        label.horizontalAlignment = JLabel.CENTER
        frame.contentPane.add(label, BorderLayout.CENTER)
        val button = JButton("Click!")
        button.addActionListener {
            label.text = "waiting"
            thread {
                val result =
                        URL("http://127.0.0.1:8080/hello/10000")
                                .openStream()
                                .bufferedReader()
                                .use { it.readText() }
                invokeLater {
                    label.text = result
                }
            }
        }
        frame.contentPane.add(button, BorderLayout.SOUTH)
        frame.pack()
        frame.setLocationRelativeTo(null)
        frame.isVisible = true
    }
}
