package io.jrb.common.model

import io.jrb.common.resource.TestResource
import java.time.Instant
import java.util.UUID

data class TestEntity(
    override val id: String?,
    override val guid: UUID?,
    val name: String,
    override val createdOn: Instant?,
    override val createdBy: String?,
    override val modifiedOn: Instant?,
    override val modifiedBy: String?
) : Entity {

    data class Builder(
        private var name: String? = null
    ) : EntityBuilder<TestEntity, TestResource>() {
        constructor(resource: TestResource): this() {
            this.guid = resource.guid
            this.name = resource.name
            this.createdOn = resource.createdOn
            this.createdBy = resource.createdBy
            this.modifiedOn = resource.modifiedOn
            this.modifiedBy = resource.modifiedBy
        }

        constructor(entity: TestEntity): this() {
            this.id = entity.id
            this.guid = entity.guid
            this.name = entity.name
            this.createdOn = entity.createdOn
            this.createdBy = entity.createdBy
            this.modifiedOn = entity.modifiedOn
            this.modifiedBy = entity.modifiedBy
        }

        fun name(name: String?) = apply { this.name = name }

        override fun build() = TestEntity(
            id = this.id,
            guid = this.guid,
            name = this.name!!,
            createdOn = this.createdOn,
            createdBy = this.createdBy,
            modifiedOn = this.modifiedOn,
            modifiedBy = this.modifiedBy
        )
    }

}
