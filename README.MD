# Kotlin Multiplatform Compose Sample App with Support for Android, Desktop, JS and iOS Targets

This is a sample app which demonstrates the project structure of a [Jetbrains Compose](https://github.com/JetBrains/compose-jb) app for all relevant build targets including iOS and JS (WASM).

## Used Libraries

It uses a set of integral libraries to accomplish usual app features:

- [PreCompose](https://github.com/Tlaster/PreCompose) for routing
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) for async code
- [Ktor client](https://ktor.io/docs/welcome.html) as http client
- [SQDelight](https://cashapp.github.io/sqldelight/1.5.4/) for SQLight databases

## Common Code

This sample app uses mainly the shared package to do all UI and business logic. Nothing is coded in Swift UI or any other native interface library.

### Licence

The MIT License (MIT)

Copyright (c) 2023

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.