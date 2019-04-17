package com.bytedance.atp.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class Entity {

    @Id
    public String id;

    @Override

    public boolean equals(Object obj) {

        Entity other = (Entity) obj;

        if (other == null)

            return false;

        if (this == other) // Reference equality

            return true;

        if (!this.getClass().equals(other.getClass()))

            return false;

        if (this.id.isEmpty() || other.getId().isEmpty())

            return false;

        return other.getId().equals(id); //identifier equality

    }


}
