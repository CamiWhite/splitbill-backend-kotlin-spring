package com.splitbill.group.service

import com.splitbill.group.model.GroupModel
import com.splitbill.group.repository.GroupRepository
import org.springframework.stereotype.Service

@Service
class GroupServiceImpl(
    val groupRepository: GroupRepository
) : GroupService {

    /**
     * Creates a new group given the name and the user who created it
     *
     * @param name The name of the group
     * @param profileId The profile id of the user who created it
     * @return
     */
    override fun create(name: String, profileId: String): GroupModel {
        return groupRepository.save(GroupModel(name, profileId))
    }

    /**
     * List the groups on which this profileId is part of
     *
     * @param profileId The profileId
     * @return
     */
    override fun list(profileId: String): List<GroupModel> {
        return groupRepository.findAllByProfileIdsEquals(profileId)
    }
}