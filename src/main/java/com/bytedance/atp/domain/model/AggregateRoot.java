package com.bytedance.atp.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class AggregateRoot extends Entity {

    public int version ;

    public List<DomainEvent> events = new ArrayList<>();
}
