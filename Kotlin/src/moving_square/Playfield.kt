package moving_square

import java.awt.Color
import java.awt.Dimension
import java.awt.Point
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.JPanel

class Playfield : JPanel(null) {

    private val square = Square()

    var squareX: Int = 0
        set(value) {
            square.location = Point(value, square.location.y)
            field = value
        }

    var squareY: Int = 0
        set(value) {
            square.location = Point(square.location.x, value)
            field = value
        }

    val squareW: Int
        get() = square.width

    val squareH: Int
        get() = square.height

    init {
        background = Color.BLACK
        add(square)
        addComponentListener(object : ComponentAdapter() {
            override fun componentResized(e: ComponentEvent?) {
                val percentW = e!!.component!!.width / 100f
                val percentH = e.component!!.height / 100f
                val ratio = percentW / percentH
                val w = (percentW * 4f).toInt()
                val h = (percentH * 4f * ratio).toInt()
                square.size = Dimension(w, h)
            }
        })
        preferredSize = Dimension(800, 600)
        size = preferredSize
    }

    fun hitTopBorder() = squareY <= 0

    fun hitBottomBorder() = (squareY + square.height) >= height

    fun hitLeftBorder() = squareX <= 0

    fun hitRightBorder() = (squareX + square.width) >= width
}
