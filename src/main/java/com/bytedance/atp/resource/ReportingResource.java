package com.bytedance.atp.resource;

import com.bytedance.atp.domain.model.report.Reporting;
import com.bytedance.atp.share.req.CatReportReq;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url = "")
@RequestMapping(value = "/report")
public interface ReportingResource {

    @RequestMapping(method = RequestMethod.GET,
            value = "/cat",
            consumes = "application/json",
            produces = "application/json"
    )
    public List<Reporting> catReportOfRuleGroup(CatReportReq req);


    @RequestMapping(method = RequestMethod.GET,
            value = "/cat",
            consumes = "application/json",
            produces = "application/json"
    )
    public Reporting catReportOfFlow(CatReportReq req);
}
