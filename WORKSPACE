load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

_RULES_JVM_EXTERNAL_TAG = "4.1"

_RULES_JVM_EXTERNAL_SHA = "f36441aa876c4f6427bfb2d1f2d723b48e9d930b62662bf723ddfb8fc80f0140"

http_archive(
    name = "rules_jvm_external",
    sha256 = _RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % _RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % _RULES_JVM_EXTERNAL_TAG,
)

local_repository(
    name = "release_archive",
    path = "third_party/rules_kotlin/src/main/starlark/release_archive",
)

load("@release_archive//:repository.bzl", "archive_repository")

archive_repository(
    name = "io_bazel_rules_kotlin",
    local_path = "third_party/rules_kotlin"
)

_DAGGER_TAG = "2.38.1"

_DAGGER_SHA = "d20c81fd622f8bbb714239ea3cb7c963e77fc8ec3c88487f912189a9538071e9"

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

android_sdk_repository(
    name = "androidsdk",
    api_level = 31,
    build_tools_version = "30.0.3",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

_KOTLIN_VERSION = "1.5.21"

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

load(
    "@io_bazel_rules_kotlin//kotlin:repositories.bzl",
    "kotlin_repositories",
    "kotlinc_version",
)

_KOTLINC_RELEASE = kotlinc_version(
    release = "1.5.21",
    sha256 = "f3313afdd6abf1b8c75c6292f4e41f2dbafefc8f6c72762c7ba9b3daeef5da59",
)

kotlin_repositories(compiler_release = _KOTLINC_RELEASE)

register_toolchains("//:kotlin_toolchain")
