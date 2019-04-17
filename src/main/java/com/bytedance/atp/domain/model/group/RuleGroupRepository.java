package com.bytedance.atp.domain.model.group;

import com.bytedance.atp.domain.model.cc.ConfigCenter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleGroupRepository extends MongoRepository<RuleGroup, Long> {

    RuleGroup findByGroupIdentifierCreatorAndGroupIdentifierGroupName(String creator,String groupName);
}
