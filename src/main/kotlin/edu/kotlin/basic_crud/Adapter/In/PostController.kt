package edu.kotlin.basic_crud.Adapter.In

import edu.kotlin.basic_crud.Port.In.PostInboundPort
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController(private val postInboundPort: PostInboundPort) {
}