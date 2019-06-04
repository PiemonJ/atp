package com.flute.atp.domain.model.report;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportingRepository extends MongoRepository<Reporting, String> {

    Reporting findByRuleGroupIdAndFlowId(String ruleGroupId,String flowId);

    List<Reporting> findAllByRuleGroupId(String ruleGroupId);
}
