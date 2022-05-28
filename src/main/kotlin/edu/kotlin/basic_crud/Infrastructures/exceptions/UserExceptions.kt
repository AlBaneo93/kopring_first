package edu.kotlin.basic_crud.Infrastructures.exceptions

class UserNotFoundException(message: String?) : Exception(message)

class JwtExtractException(message: String?) : Exception(message)

class TokenExpiredException(message: String?) : Exception(message)