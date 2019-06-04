package com.flute.atp.common;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Template {

    private List<Rule> rules;

    private Map<ConfigScalar,String> configers;

    @NoArgsConstructor
    @AllArgsConstructor
    public static class Builder{

        private List<PARAM> ruleParams = new ArrayList<>();

        private List<Rule> rules = new ArrayList<>();

        public Template build(){

            Map<ConfigScalar, String> configers = ruleParams.stream()
                    .map(param -> param.configers)
                    .map(map -> map.entrySet())
                    .flatMap(Set::stream)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            return new Template(rules,configers);
        }




        public COVERAGE_PARAM applyRuleOfConverage(){

            rules.add(Rule.COVERAGE);

            COVERAGE_PARAM param = new COVERAGE_PARAM();

            ruleParams.add(param);

            return param;

        }

        public WINDOW_PERIOD_RELEASE_PARAM applyRuleOfWindowPeriodRelease(){

            rules.add(Rule.WINDOW_PERIOD_RELEASE);

            WINDOW_PERIOD_RELEASE_PARAM param = new WINDOW_PERIOD_RELEASE_PARAM();

            ruleParams.add(param);

            return param;
        }



        abstract class PARAM{
            Map<ConfigScalar,String> configers = new ConcurrentHashMap<>();

            public String jsonPutty(Object jo){
                return JSON.toJSONString(jo);
            }
        }



        public class COVERAGE_PARAM extends PARAM{
            BigDecimal coverage;

            private Function<BigDecimal, Tuple2<ConfigScalar, BigDecimal>> coverageCurrying =
                    Tuple2.<ConfigScalar, BigDecimal>currying(ConfigScalar.CODE_COVERAGE);

            public COVERAGE_PARAM richCoverage(BigDecimal coverage){
                Tuple2<ConfigScalar, BigDecimal> tuple = coverageCurrying.apply(coverage);
                coverage = tuple._2;
                configers.put(tuple._1,jsonPutty(tuple._2));
                return this;
            }

        }

        public class WINDOW_PERIOD_RELEASE_PARAM extends PARAM{

            DateInterval dateInterval;

            private Function<DateInterval, Tuple2<ConfigScalar, DateInterval>> dateIntervalCurrying =
                    Tuple2.<ConfigScalar, DateInterval>currying(ConfigScalar.RELEASE_VALID_DAY);

            public WINDOW_PERIOD_RELEASE_PARAM richDateInterval(Date from,Date to){
                Tuple2<ConfigScalar, DateInterval> tuple = dateIntervalCurrying.apply(new DateInterval(from, to));
                dateInterval = tuple._2;
                configers.put(tuple._1,jsonPutty(tuple._2));
                return this;
            }




        }
















    }



    public static Template.Builder builder(){

        return new Template.Builder();
    }





}
