package tornadofx

import kotlinx.cinterop.*
import libui.*

data class View(
  var title: String? = null,
  var width: Int? = null,
  var height: Int? = null,
  var hasMenubar: Boolean = false,
  var children: List<Control>? = null
): Control()

fun view(init: View.() -> Unit): View = View().apply(init).apply {
  memScoped {
    val options = alloc<uiInitOptions>()
    val error = uiInit(options.ptr)
    if (error != null) throw Error("Error: '${error.toKString()}'")

    val window = uiNewWindow(title, width!!, height!!, menubarBooleanToInt(hasMenubar))
    uiWindowSetMargined(window, 1)

    fun onClosing(window: CPointer<uiWindow>?, data: COpaquePointer?): Int {
        uiQuit()
        return 1
    }
    uiWindowOnClosing(window, staticCFunction(::onClosing), null)
    uiControlShow(window?.reinterpret())
    uiMain()
    uiUninit()
  }
}

fun menubarBooleanToInt(hasMenubar: Boolean): Int {
  if (hasMenubar == true) return 1
  return 0
}
