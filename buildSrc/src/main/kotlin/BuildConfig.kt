object BuildConfig {
    const val MINECRAFT_VERSION: String = "26.3-rc-2"
    const val FABRIC_LOADER_VERSION: String = "0.19.5"
    const val NEOFORGE_VERSION: String = "26.2.0.0-beta"
    const val UKULIB_VERSION: String = "2.1.1+26.3-rc-2-build.345"

    const val MOD_VERSION: String = "1.9.0"

    const val MODRINTH_PROJECT_ID: String = "gVFdvNDw"

    fun createVersionString(): String {
        return "$MOD_VERSION+mc$MINECRAFT_VERSION"
    }
}