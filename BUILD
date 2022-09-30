load(
    "@io_bazel_rules_kotlin//kotlin:kotlin.bzl",
    "define_kt_toolchain",
)
load(
    "@io_bazel_rules_kotlin//kotlin:core.bzl",
    "kt_javac_options",
    "kt_kotlinc_options",
)
load("@dagger//:workspace_defs.bzl", "hilt_android_rules")
load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_import")

# Kotlin Toolchain
kt_kotlinc_options(
    name = "kt_kotlinc_options",
)

kt_javac_options(
    name = "kt_javac_options",
)

define_kt_toolchain(
    name = "kotlin_toolchain",
    api_version = "1.7",
    jvm_target = "11",
    kotlinc_options = "//:kt_kotlinc_options",
    language_version = "1.7",
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
    dex_shards = 2,
    deps = [
        "//kotlin/com/example/app:examplelib",
    ],
)

load("@rules_python//python:defs.bzl", "py_runtime_pair")

py_runtime(
    name = "py3_runtime",
    interpreter_path = "/usr/bin/python3",
    python_version = "PY3",
    stub_shebang = "#!/usr/bin/python3",
)

py_runtime_pair(
    name = "py_runtime_pair",
    py2_runtime = None,
    py3_runtime = ":py3_runtime",
)

toolchain(
    name = "py_toolchain",
    toolchain = ":py_runtime_pair",
    toolchain_type = "@rules_python//python:toolchain_type",
)

# Add missing 'sun.misc' files to coroutines artifact
# Used in 'override_targets' by referencing @//:kotlinx_coroutines_core_jvm
kt_jvm_import(
    name = "kotlinx_coroutines_core_jvm_fixed",
    jars = ["@kotlinx_coroutines_core_fixed//:v1/https/repo1.maven.org/maven2/org/jetbrains/kotlinx/kotlinx-coroutines-core-jvm/1.6.4/kotlinx-coroutines-core-jvm-1.6.4.jar"],
    srcjar = "@kotlinx_coroutines_core_fixed//:v1/https/repo1.maven.org/maven2/org/jetbrains/kotlinx/kotlinx-coroutines-core-jvm/1.6.4/kotlinx-coroutines-core-jvm-1.6.4-sources.jar",
    visibility = ["//visibility:public"],
    deps = [
        "//patches/sun_misc",
        "@maven//:org_jetbrains_kotlin_kotlin_stdlib",
    ],
)


aar_import(
    name = "androidx_core_core_fixed",
    aar = "@androidx_core_core_fixed//:v1/https/maven.google.com/androidx/core/core/1.8.0/core-1.8.0.aar",
#    srcjar = "@androidx_core_core_fixed//:v1/https/maven.google.com/androidx/core/core/1.8.0/core-1.8.0-sources.jar",
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:androidx_concurrent_concurrent_futures",
        "@maven//:androidx_lifecycle_lifecycle_common",
        "@maven//:com_google_guava_guava",
    ],
)

