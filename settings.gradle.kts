include(":app")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "NerdTranslator"
include(":app:main_screen")
include(":app:core")
include(":app:tags_overview_screen")
