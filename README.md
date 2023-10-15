## ProDialog

ProDialog is an Android library that allows you to create customizable and user-friendly dialogs in your Android applications.

### Installation

You can include the ProDialog library in your Android project using [JitPack](https://jitpack.io).

#### Gradle (Groovy) Users

Add the JitPack repository to your `build.gradle` file:

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Next, add the ProDialog dependency to your app-level `build.gradle` file:

```gradle
dependencies {
    implementation 'com.github.GtechGovind:ProDialog:1.0'
}
```

Sync your project to apply the changes.

#### Kotlin DSL (build.gradle.kts) Users

Add the JitPack repository to your `build.gradle.kts` file:

```kotlin
allprojects {
    repositories {
        maven("https://jitpack.io")
    }
}
```

Next, add the ProDialog dependency to your app-level `build.gradle.kts` file:

```kotlin
dependencies {
    implementation("com.github.GtechGovind:ProDialog:1.0")
}
```

Sync your project to apply the changes.

### Usage

To use ProDialog in your Android project, you need to create an instance of `ProDialogBuilder`:

```java
ProDialogBuilder proDialog = ProDialog.build(this)
```

You can then customize the dialog using various methods provided by the builder. For example, to set the title of the dialog:

```java
proDialog.title("Success!", null, 0)
```

To show the dialog, call the `show()` method:

```java
proDialog.show()
```

### Customization

ProDialog allows you to customize various aspects of the dialog, including the title, description, type (e.g., success, error), button actions, and more. Here are some customization options:

- `title()`: Set the title of the dialog.
- `description()`: Set a description for the dialog.
- `type()`: Set the type of the dialog (success, info, alert, error).
- `onPositive()`: Configure the positive button with text and actions.
- `onNegative()`: Configure the negative button with text and actions.
- `background()`: Set the dialog's background color.
- `position()`: Set the position of the dialog (center, bottom).
- `dialogAnimation()`: Set a custom animation for the dialog.

### Examples

Here are some examples of how to use ProDialog:

```java
// Create a success dialog with a custom animation
ProDialog.build(this)
    .title("Success!", null, 0)
    .type(ProDialog.TYPE.SUCCESS)
    .dialogAnimation(R.raw.success_animation)
    .show()
```

```java
// Create an alert dialog with custom button actions
ProDialog.build(this)
    .title("Alert", null, 0)
    .type(ProDialog.TYPE.ALERT)
    .onPositive("OK", null, R.color.green, () -> {
        // Positive button action
    })
    .onNegative("Cancel", null, R.color.red, () -> {
        // Negative button action
    })
    .show()
```

### License

This library is licensed under the [MIT License](LICENSE). Feel free to use it in your projects.

If you have any questions or encounter any issues, please [create an issue](https://github.com/GtechGovind/ProDialog/issues) on our GitHub repository.
