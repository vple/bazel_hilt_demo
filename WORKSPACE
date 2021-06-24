load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

_RULES_JVM_EXTERNAL_TAG = "4.0"

_RULES_JVM_EXTERNAL_SHA = "31701ad93dbfe544d597dbe62c9a1fdd76d81d8a9150c2bf1ecf928ecdf97169"

http_archive(
    name = "rules_jvm_external",
    sha256 = _RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % _RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % _RULES_JVM_EXTERNAL_TAG,
)

_RULES_KOTLIN_VERSION = "1.5.0-alpha-3"

_RULES_KOTLIN_SHA = "eeae65f973b70896e474c57aa7681e444d7a5446d9ec0a59bb88c59fc263ff62"

http_archive(
    name = "io_bazel_rules_kotlin",
    sha256 = _RULES_KOTLIN_SHA,
    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/v{}/rules_kotlin_release.tgz".format(_RULES_KOTLIN_VERSION)],
)

_DAGGER_TAG = "2.37"

_DAGGER_SHA = "0f001ed38ed4ebc6f5c501c20bd35a68daf01c8dbd7541b33b7591a84fcc7b1c"

http_archive(
    name = "dagger",
    sha256 = _DAGGER_SHA,
    strip_prefix = "dagger-dagger-%s" % _DAGGER_TAG,
    urls = ["https://github.com/google/dagger/archive/dagger-%s.zip" % _DAGGER_TAG],
)

load(
    "@dagger//:workspace_defs.bzl",
    "HILT_ANDROID_ARTIFACTS",
    "HILT_ANDROID_REPOSITORIES",
)

android_sdk_repository(name = "androidsdk")

load("@rules_jvm_external//:defs.bzl", "maven_install")

_KOTLIN_VERSION = "1.4.32"

maven_install(
    artifacts = [
        "androidx.activity:activity-ktx:1.2.3",
        "androidx.appcompat:appcompat:1.2.0",
        "androidx.core:core-ktx:1.3.2",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1",
        "com.google.android.material:material:1.2.1",
        "org.jetbrains.kotlin:kotlin-stdlib:{}".format(_KOTLIN_VERSION),
    ] + HILT_ANDROID_ARTIFACTS,
    fetch_sources = True,
    repositories = HILT_ANDROID_REPOSITORIES,
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories")

_KOTLINC_RELEASE_SHA = "dfef23bb86bd5f36166d4ec1267c8de53b3827c446d54e82322c6b6daad3594c"

_DOWNLOAD_URL = "https://github.com/JetBrains/kotlin/releases/download/v{v}/kotlin-compiler-{v}.zip"

_KOTLINC_RELEASE = {
    "urls": [
        _DOWNLOAD_URL.format(v = _KOTLIN_VERSION),
    ],
    "sha256": _KOTLINC_RELEASE_SHA,
}

kotlin_repositories(compiler_release = _KOTLINC_RELEASE)

register_toolchains("//:kotlin_toolchain")
