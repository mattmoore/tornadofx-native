build: prepare libui-bindings kotlin-native

prepare:
	@if [ ! -d build ]; then mkdir build; fi

kotlin-native:
	@kotlinc-native \
		-o build/main \
		-l build/libui.klib \
		src/nativeMain/kotlin/tornadofx/*.kt \
		src/nativeMain/kotlin/*.kt

libui-bindings:
	@cinterop \
		-def src/nativeInterop/cinterop/libui.def \
		-o build/libui.klib

run:
	@build/main.kexe

clean:
	@if [ -d build ]; then rm -rf build; fi
