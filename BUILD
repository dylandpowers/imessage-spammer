java_library(
     name = "app_lib",
     srcs = glob(["src/**/*.java"]),
     deps = [
         "@maven//:org_openjfx_javafx_controls_mac",
         "@maven//:org_openjfx_javafx_graphics_mac",
         "@maven//:org_openjfx_javafx_base_mac"
     ],
)

java_binary(
    name = "app",
    main_class = "com.dylanpowers.imessagespammer.Main",
    runtime_deps = [":app_lib"],
)
 
