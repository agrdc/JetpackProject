package bilulo.com.jetpackproject.data.model

import bilulo.com.jetpackproject.data.enumerators.StatusEnum

data class Resource<out T>(val status: StatusEnum, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(StatusEnum.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(StatusEnum.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(StatusEnum.LOADING, data, null)
        }
    }
}
