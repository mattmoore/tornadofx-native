package tornadofx

import kotlinx.cinterop.*
import libui.*

class Button(
        var title: String? = null,
        private var uiButton: CPointer<uiButton>? = null,
        private var clicked: () -> Unit = {}
): Control() {
    init {
        uiButton = uiNewButton("libui говорит: click me!")
    }

    fun clicked(function: () -> Unit) {
//        fun saySomething(button: CPointer<uiButton>?, data: COpaquePointer?) {
//            uiMultilineEntryAppend(data?.reinterpret(),
//                    "Hello, World!  Ciao, mondo!\n" +
//                            "Привет, мир!  你好，世界！\n\n")
//        }
//        uiButtonOnClicked(uiButton, staticCFunction(::saySomething), scroll)
        clicked = function
    }
}

fun button(init: Button.() -> Unit): Button = Button().apply(init)
