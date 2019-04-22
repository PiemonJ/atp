package com.bytedance.atp;

import com.bytedance.atp.domain.model.report.Reporting;
import com.bytedance.atp.domain.model.report.ReportingRepository;
import com.bytedance.atp.resource.ReportingResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportingTester {
    @Autowired
    private ReportingRepository reportingRepository;

    //e7fc1595-14b5-4559-9162-81eb76b26f7f

    @Test
    public void test(){
        Reporting one = reportingRepository.findOne("e7fc1595-14b5-4559-9162-81eb76b26f7f");
        System.out.println(one);

    }
}
