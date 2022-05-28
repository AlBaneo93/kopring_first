package edu.kotlin.basic_crud.Infrastructures.utils


class ApiResponse {

  companion object {

    fun <T> success(response: T?): ApiResults<T> {
      return ApiResults(response, true, null)
    }


    fun error(code: Int, msg: String?): ApiResults<Boolean> {
      return ApiResults<Boolean>(null, false, ApiError(code = code, msg = msg))
    }

    fun error(code: Int, msg: String?, ex: Exception): ApiResults<Boolean> {
      return ApiResults<Boolean>(null, false, ApiError(msg = ex.message))
    }
  }

  data class ApiError(val msg: String?) { constructor(code: Int, msg: String?) : this(msg)
  }

  data class ApiResults<T>(private val response: T? = null, private val success: Boolean? = null, private val error: ApiError? = null)

}

