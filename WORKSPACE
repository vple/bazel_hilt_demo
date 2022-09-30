load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

_RULES_JVM_EXTERNAL_TAG = "4.1"

_RULES_JVM_EXTERNAL_SHA = "f36441aa876c4f6427bfb2d1f2d723b48e9d930b62662bf723ddfb8fc80f0140"

http_archive(
    name = "rules_jvm_external",
    sha256 = _RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % _RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % _RULES_JVM_EXTERNAL_TAG,
)

RULES_KOTLIN_VERSION = "1.6.0"

RULES_KOTLIN_SHA = "a57591404423a52bd6b18ebba7979e8cd2243534736c5c94d35c89718ea38f94"

http_archive(
    name = "io_bazel_rules_kotlin",
    sha256 = RULES_KOTLIN_SHA,
    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/v%s/rules_kotlin_release.tgz" % RULES_KOTLIN_VERSION],
)

_DAGGER_TAG = "2.44"

_DAGGER_SHA = "8c0876d46e8ce9332c4d4fbc2444420e0d75f041b3d4bab8313d2542d1e758ff"

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
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

#_KOTLIN_VERSION = "1.5.21"
_KOTLIN_VERSION = "1.7.10"

maven_install(
    artifacts = [
        "androidx.activity:activity-ktx:1.5.1",
        "androidx.appcompat:appcompat:1.2.0",
        "androidx.core:core-ktx:1.8.0",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1",
        "androidx.compose.material:material:1.3.0-beta03",
        "com.google.guava:guava:31.1-android",
        "com.google.guava:listenablefuture:1.0",
        "org.jetbrains.kotlin:kotlin-stdlib:{}".format(_KOTLIN_VERSION),
    ] + HILT_ANDROID_ARTIFACTS,
    fetch_sources = True,
    override_targets = {
        "androidx.core:core": "@//:androidx_core_core_fixed",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm": "@//:kotlinx_coroutines_core_jvm_fixed",
    },
    repositories = HILT_ANDROID_REPOSITORIES,
)

load(
    "@io_bazel_rules_kotlin//kotlin:repositories.bzl",
    "kotlin_repositories",
    "kotlinc_version",
)

_KOTLINC_RELEASE = kotlinc_version(
    release = "1.7.10",
    sha256 = "7683f5451ef308eb773a686ee7779a76a95ed8b143c69ac247937619d7ca3a09",
)

kotlin_repositories(compiler_release = _KOTLINC_RELEASE)

register_toolchains("//:kotlin_toolchain")

register_toolchains(":py_toolchain")

maven_install(
    name = "kotlinx_coroutines_core_fixed",
    artifacts = [
        # Workaround to add missing 'sun.misc' dependencies to 'kotlinx-coroutines-core-jvm' artifact
        # Check root BUILD file and 'override_targets' arg of a primary 'maven_install'
        "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.4",
    ],
    fetch_sources = True,
    repositories = ["https://repo1.maven.org/maven2"],
)

maven_install(
    name = "androidx_core_core_fixed",
    artifacts = [
        "androidx.core:core:1.8.0",
    ],
    fetch_sources = True,
    repositories = [
        "https://maven.google.com/",
        "https://repo1.maven.org/maven2",
    ],
)

