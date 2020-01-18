package moving_square

import java.awt.Color
import java.awt.Graphics
import javax.swing.JComponent

class Square : JComponent() {

    override fun paint(g: Graphics?) {
        g?.color = Color.white
        g?.setPaintMode()
        g?.fillRect(0, 0, width, height)
        super.paint(g)
    }
}