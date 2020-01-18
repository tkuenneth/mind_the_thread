package moving_square

import javax.swing.JFrame
import javax.swing.SwingUtilities.invokeLater

const val offset = 2

fun main() {
    invokeLater {
        val f = JFrame("Moving Square")
        val playfield = Playfield()
        f.contentPane = playfield
        f.pack()
        f.setLocationRelativeTo(null)
        var toLeft = Math.random() < .5
        var toTop = Math.random() < .5
        playfield.squareX = (Math.random() * playfield.width).toInt()
        playfield.squareY = (Math.random() * playfield.height).toInt()
        f.isVisible = true
        val t = Thread {
            while (true) {
                if (toLeft) {
                    if (playfield.hitLeftBorder()) {
                        toLeft = false
                        playfield.squareX = 0
                    } else
                        playfield.squareX -= offset
                } else {
                    if (playfield.hitRightBorder()) {
                        toLeft = true
                        playfield.squareX = playfield.width - playfield.squareW - 1
                    } else
                        playfield.squareX += offset
                }
                if (toTop) {
                    if (playfield.hitTopBorder()) {
                        toTop = false
                        playfield.squareY = 0
                    } else
                        playfield.squareY -= offset
                } else {
                    if (playfield.hitBottomBorder()) {
                        toTop = true
                        playfield.squareY = playfield.height - playfield.squareH - 1
                    } else
                        playfield.squareY += offset
                }
                invokeLater {
                    f.repaint(playfield.squareX - offset, playfield.squareY - offset,
                            playfield.squareW + offset * 2, playfield.squareH + offset * 2)
                }
                Thread.sleep(2)
            }
        }
        t.start()
    }
}
