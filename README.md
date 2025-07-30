## Run demonstration:

1. In `ru.dchertanov.Main.testEpubParsing()` specify the path to the `.epub` file to be parsed
2. Run program - `gradlew run`

## Solve problem with Slf4j (if happened):

Need to exclude dependency `slf4j-simple`

```kotlin
dependencies {
    implementation("com.positiondev.epublib:epublib-core:3.1") {
        exclude(group = "org.slf4j", module = "slf4j-simple")
    }
}
```