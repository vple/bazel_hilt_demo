load(
    "@io_bazel_rules_kotlin//kotlin:kotlin.bzl",
    "define_kt_toolchain",
)
load(
    "@io_bazel_rules_kotlin//kotlin:core.bzl",
    "kt_javac_options",
    "kt_kotlinc_options",
)
load(
    "@bazel_tools//tools/jdk:default_java_toolchain.bzl",
    "default_java_toolchain",
)
load("@dagger//:workspace_defs.bzl", "hilt_android_rules")

# Java Toolchain
default_java_toolchain(
    name = "java_toolchain",
    visibility = ["//visibility:public"],
)

# Kotlin Toolchain
kt_kotlinc_options(
    name = "kt_kotlinc_options",
    x_use_experimental = True,
)

kt_javac_options(
    name = "kt_javac_options",
)

define_kt_toolchain(
    name = "kotlin_toolchain",
    api_version = "1.5",
    experimental_use_abi_jars = False,
    javac_options = "//:kt_javac_options",
    jvm_target = "11",
    kotlinc_options = "//:kt_kotlinc_options",
    language_version = "1.5",
)

hilt_android_rules()

android_binary(
    name = "exampleapp",
    custom_package = "com.example.app",
    manifest = "AndroidManifest.xml",
    manifest_values = {
        "minSdkVersion": "26",
        "versionCode": "1",
        "versionName": "1.0",
        "targetSdkVersion": "31",
    },
    multidex = "native",
    deps = [
        "//kotlin/com/example/app:examplelib",
    ],
)
