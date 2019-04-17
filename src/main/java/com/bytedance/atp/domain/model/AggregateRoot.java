package com.bytedance.atp.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class AggregateRoot extends Entity {

    public int version ;

    @Transient
    public List<DomainEvent> events = new ArrayList<>();
}
