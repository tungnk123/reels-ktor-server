package helper

import io.github.cdimascio.dotenv.dotenv

object EnvHelper {
    private val local by lazy {
        dotenv {
            ignoreIfMissing = true
            ignoreIfMalformed = true
        }
    }

    fun get(name: String, default: String): String =
        System.getenv(name) ?: local[name] ?: default
}
