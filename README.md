# TornadoFX Native

This project is intended to implement TornadoFX for Kotlin Native.

## Why not just use TornadoFX?

If you're targeting the JVM, then use TornadoFX. If you want a GUI library for Kotlin Native that uses the same syntax as TornadoFX, that's what this library is for.

## Why use TornadoFX syntax specifically?

Because I think TornadoFX is pretty cool! I like what Edvin Syse has done with his DSL. My hope with this project is to bring the awesomeness of Edvin's TornadoFX DSLs to Kotlin Native, because I have an interest in Kotlin Native.

## What's the state of this project?

I've just begun the project recently. As such, it is very early and not at all ready for production use. I am currently investigating the best ways to handle interop with different operating systems.

## How does it work?

### GUI Development on JVM with TornadoFX

TornadoFX is built on top of JavaFX. As such, it is heavily tied to the JVM. However, it is able to rely on the JVM for handling rendering, etc... Since the JavaFX/JVM system isn't available for Kotlin Native, I've had to take a different approach.

### GUI Development on Native without JavaFX

Each operating system has different native toolkits for GUI development. Macos has Cocoa, Windows has Win32, Linux typically has GTK. Given that each of these toolkits are vastly different, it is necessary to have a separate native C library provide an abstraction layer to interop with each of those toolkits. Initially, I thought I would have to build my own. However, I discovered libui, which is an abstraction layer for GUI development across the different OSs/GUI toolkits. So far, libui provides what I need, so I am relying on that to provide an abstraction layer across the toolkits on each OS. If I find that libui doesn't have a feature I need, I may try to contribute to that project, or fork it and implement any additional needed features myself.

### Connecting Everything to Kotlin

To bring libui into Kotlin, this project uses Kotlin's cinterop tool to generate C->Kotlin bindings. My library then translates the DSLs from TornadoFX to the C-based libui interop.

## How do I compile/run this?

### Installing Dependencies

You will need to first clone, build and install libui. Follow the directions here:  https://github.com/andlabs/libui

### Compiling The Project

To compile the project, clone it to your machine and CD into the directory:

```shell
git clone https://github.com/mattmoore/tornadofx-native.git
cd tornadofx-native
./gradlew build
```
