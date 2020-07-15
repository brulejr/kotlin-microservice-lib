package io.jrb.common.resource

import io.jrb.common.model.TestEntity
import java.time.Instant
import java.util.UUID

data class TestResource(
    override val guid: UUID?,
    val name: String,
    override val createdOn: Instant?,
    override val createdBy: String?,
    override val modifiedOn: Instant?,
    override val modifiedBy: String?
) : Resource {

    data class Builder(
        private var name: String? = null
    ) : ResourceBuilder<TestResource, TestEntity>() {
        constructor(entity: TestEntity): this() {
            this.guid = entity.guid
            this.name = entity.name
            this.createdOn = entity.createdOn
            this.createdBy = entity.createdBy
            this.modifiedOn = entity.modifiedOn
            this.modifiedBy = entity.modifiedBy
        }

        fun name(name: String?) = apply { this.name = name }

        override fun build() = TestResource(
            guid = this.guid,
            name = this.name!!,
            createdOn = this.createdOn,
            createdBy = this.createdBy,
            modifiedOn = this.modifiedOn,
            modifiedBy = this.modifiedBy
        )
    }

}
