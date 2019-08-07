package tornadofx

import kotlinx.cinterop.*
import libui.*

class Button(
  var title: String? = null,
  var uiButton: CPointer<uiControl>? = null
)

//fun button(init: Button.() -> Unit): Button = Button().apply(init).apply {
//  uiButton = uiNewButton("libui говорит: click me!")
//}
