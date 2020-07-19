package io.jrb.common.rest

import io.jrb.common.resource.ErrorResponseEntity
import io.jrb.common.service.PatchInvalidException
import io.jrb.common.service.ResourceNotFoundException
import io.jrb.common.service.ServiceException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalErrorHandler {

    @ExceptionHandler(PatchInvalidException::class)
    fun forumException(exception: PatchInvalidException) = ErrorResponseEntity.badRequest(exception.message)

    @ExceptionHandler(ResourceNotFoundException::class)
    fun forumException(exception: ResourceNotFoundException) = ErrorResponseEntity.notFound(exception.message)

    @ExceptionHandler(ServiceException::class)
    fun forumException(exception: ServiceException) = ErrorResponseEntity.serverError(exception.message)

}