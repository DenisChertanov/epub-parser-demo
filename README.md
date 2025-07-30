## Запуск демонстрации:

1. В `ru.dchertanov.Main.testEpubParsing()` необходимо указать путь до epub файла, который необходимо распарсить
2. Запустить программу - `gradlew run`

## Исправление проблемы с Slf4j (если возникает):

Необходимо исключить зависимость `slf4j-simple`

```kotlin
dependencies {
    implementation("com.positiondev.epublib:epublib-core:3.1") {
        exclude(group = "org.slf4j", module = "slf4j-simple")
    }
}
```