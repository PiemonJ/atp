package com.flute.atp.resource;

import com.flute.atp.domain.model.report.Reporting;
import com.flute.atp.share.req.CatReportReq;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "reportingController",url = "http://localhost:8080/")
@RequestMapping(value = "/report")
public interface ReportingResource {



    @RequestMapping(method = RequestMethod.GET,
            value = "/cat",
            consumes = "application/json",
            produces = "application/json"
    )
    public Reporting catReportOfFlow(CatReportReq req);
}
