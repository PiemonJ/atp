package com.flute.atp.domain.model.report;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Data
@Setter
@Getter
public class Clock {

    Date flowStart;

    Date flowTerminal;
}
