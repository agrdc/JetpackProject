package bilulo.com.jetpackproject.data.api

interface IAlbumsResponse<T> {
    fun onResponseSuccess(response: T)
    fun onResponseNotFound()
    fun onResponseError(msg: String)
}