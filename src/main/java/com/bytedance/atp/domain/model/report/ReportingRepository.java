package com.bytedance.atp.domain.model.report;


import com.bytedance.atp.domain.model.group.RuleGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportingRepository extends MongoRepository<Reporting, String> {
}
