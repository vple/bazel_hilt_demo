load("@io_bazel_rules_kotlin//kotlin:android.bzl", "kt_android_library")

kt_android_library(
    name = "examplelib",
    srcs = glob(["**/*.kt"]),
    custom_package = "com.example.app",
    visibility = ["//visibility:public"],
    deps = [
        "//:hilt-android",
        "@maven//:androidx_activity_activity_ktx",
        "@maven//:androidx_appcompat_appcompat",
        "@maven//:androidx_core_core_ktx",
        "@maven//:androidx_lifecycle_lifecycle_viewmodel_ktx",
        "@maven//:androidx_compose_material_material",
        "@maven//:javax_inject_javax_inject",
        "@maven//:org_jetbrains_kotlin_kotlin_stdlib",
    ],
)
