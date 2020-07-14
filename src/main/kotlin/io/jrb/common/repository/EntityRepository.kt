package io.jrb.common.repository

import io.jrb.common.model.Entity
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor
import org.springframework.data.repository.reactive.ReactiveSortingRepository
import reactor.core.publisher.Mono
import java.util.UUID

interface EntityRepository<ENTITY : Entity> : ReactiveSortingRepository<ENTITY, Long>, ReactiveQueryByExampleExecutor<ENTITY> {

    fun findByGuid(guid: UUID): Mono<ENTITY>

}
