// package tornadofx
// 
// import kotlinx.cinterop.*
// import libui.*
// 
// data class Window(
//   var title: String? = null,
//   var width: Int? = null,
//   var height: Int? = null,
//   var hasMenubar: Boolean = false
// )
// 
// fun window(init: Window.() -> Unit): Window = Window().apply(init).apply {
//   memScoped {
//     val options = alloc<uiInitOptions>()
//     val error = uiInit(options.ptr)
//     if (error != null) throw Error("Error: '${error.toKString()}'")
// 
//     val window = uiNewWindow(title, width!!, height!!, menubarBooleanToInt(hasMenubar))
//     uiWindowSetMargined(window, 1)
// 
//     val box = uiNewVerticalBox()
//     uiBoxSetPadded(box, 1)
//     uiWindowSetChild(window, box?.reinterpret())
// 
//     val scroll = uiNewMultilineEntry()
//     uiMultilineEntrySetReadOnly(scroll, 1)
//     val button = uiNewButton("libui говорит: click me!")
//     fun saySomething(button: CPointer<uiButton>?, data: COpaquePointer?) {
//         uiMultilineEntryAppend(data?.reinterpret(),
//             "Hello, World!  Ciao, mondo!\n" +
//             "Привет, мир!  你好，世界！\n\n")
//     }
//     uiButtonOnClicked(button, staticCFunction(::saySomething), scroll)
//     uiBoxAppend(box, button?.reinterpret(), 0)
//     uiBoxAppend(box, scroll?.reinterpret(), 1)
// 
//     fun onClosing(window: CPointer<uiWindow>?, data: COpaquePointer?): Int {
//         uiQuit()
//         return 1
//     }
//     uiWindowOnClosing(window, staticCFunction(::onClosing), null)
//     uiControlShow(window?.reinterpret())
//     uiMain()
//     uiUninit()
//   }
// }
// 
// fun menubarBooleanToInt(hasMenubar: Boolean): Int {
//   if (hasMenubar == true) return 1
//   return 0
// }
