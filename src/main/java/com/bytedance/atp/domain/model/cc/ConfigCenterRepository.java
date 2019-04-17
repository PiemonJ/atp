package com.bytedance.atp.domain.model.cc;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigCenterRepository extends MongoRepository<ConfigCenter, Long> {

    ConfigCenter findByRuleGroupId(long ruleGroupId);
}
