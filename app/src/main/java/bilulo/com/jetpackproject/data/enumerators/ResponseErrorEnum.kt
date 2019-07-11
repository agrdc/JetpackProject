package bilulo.com.jetpackproject.data.enumerators

enum class ResponseErrorEnum(val message: String) {
    NOT_FOUND("The URL was not found. Please update the request URL on \"AlbumsApi.kt\" class."),
    GENERAL("There was a problem loading the albums. Please try again later."),
}
