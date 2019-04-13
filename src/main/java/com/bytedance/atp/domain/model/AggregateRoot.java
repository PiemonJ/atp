package com.bytedance.atp.domain.model;

import java.util.ArrayList;
import java.util.List;

public class AggregateRoot extends Entity {

    private int version ;

    private List<DomainEvent> events = new ArrayList<>();
}
