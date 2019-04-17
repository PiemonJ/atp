package com.bytedance.atp.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class Entity {

    @Id
    public long id;

    @Override

    public boolean equals(Object obj) {

        Entity other = (Entity) obj;

        if (other == null)

            return false;

        if (this == other) // Reference equality

            return true;

        if (!this.getClass().equals(other.getClass()))

            return false;

        if (this.id == 0 || other.getId() == 0)

            return false;

        return this.id == other.getId(); //identifier equality

    }


    @Override

    public int hashCode() {

        final int prime = 31;

        int result = 1;

        result = prime * result + (int) (id ^ (id >>> 32));

        return result;

    }

}
