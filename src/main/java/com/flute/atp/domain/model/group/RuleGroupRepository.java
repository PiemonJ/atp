package com.flute.atp.domain.model.group;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleGroupRepository extends MongoRepository<RuleGroup, String> {

    RuleGroup findByGroupIdentifierGitlab(String gitlab);
}
