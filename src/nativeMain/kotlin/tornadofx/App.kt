package tornadofx

class App(var view: String? = null)

fun app(block: App.() -> Unit): App = App().apply(block)
