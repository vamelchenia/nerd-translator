include(":app")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "NerdTranslator"
include(":app:core")
include(":app:main_screen")
include(":app:favourites_screen")
include(":app:create_tag_sheet")
include(":app:tag_screen")
