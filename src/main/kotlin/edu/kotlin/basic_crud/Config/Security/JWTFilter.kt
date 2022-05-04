package edu.kotlin.basic_crud.Config.Security

import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JWTFilter : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val access: String = request.getHeader("access")
        val refresh: String = request.getHeader("refresh")

        filterChain.doFilter(request, response)
    }
}