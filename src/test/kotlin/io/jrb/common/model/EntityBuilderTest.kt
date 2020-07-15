package io.jrb.common.model

import io.jrb.common.resource.TestResource
import io.jrb.common.test.Testable
import org.apache.commons.lang3.RandomStringUtils.randomAlphabetic
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.Instant
import java.util.UUID

internal class EntityBuilderTest : Testable {

    lateinit var id: String
    lateinit var guid: UUID
    lateinit var name: String
    lateinit var createdOn: Instant
    lateinit var createdBy: String
    lateinit var modifiedOn: Instant
    lateinit var modifiedBy: String

    @BeforeEach
    fun before() {
        id = randomAlphabetic(10, 25)
        guid = UUID.randomUUID()
        name = randomAlphabetic(10, 25)
        createdOn = Instant.now()
        createdBy = randomAlphabetic(10, 25)
        modifiedOn = Instant.now().plusSeconds(123)
        modifiedBy = randomAlphabetic(10, 25)
    }

    @Test
    fun testBuildFromEntity() {
        val entity1 = TestEntity(
            id = id,
            guid = guid,
            name = name,
            createdOn = createdOn,
            createdBy = createdBy,
            modifiedOn = modifiedOn,
            modifiedBy = modifiedBy
        )
        val entity2 : TestEntity = TestEntity.Builder(entity1)
            .build()
        assertThat(entity2, equalTo(entity1))
    }

    @Test
    fun testBuildFromResource() {
        val resource1 = TestResource(
            guid = guid,
            name = name,
            createdOn = createdOn,
            createdBy = createdBy,
            modifiedOn = modifiedOn,
            modifiedBy = modifiedBy
        )
        val entity2 : TestEntity = TestEntity.Builder(resource1)
            .build()
        assertThat(entity2, notNullValue())
        assertThat(entity2.id, nullValue())
        assertThat(entity2.guid, equalTo(guid))
        assertThat(entity2.name, equalTo(name))
        assertThat(entity2.createdOn, equalTo(createdOn))
        assertThat(entity2.createdBy, equalTo(createdBy))
        assertThat(entity2.modifiedOn, equalTo(modifiedOn))
        assertThat(entity2.modifiedBy, equalTo(modifiedBy))
    }

}
