package com.bytedance.atp.domain.model.runtime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 非线程安全
 *
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorChain {

    public AtomicBoolean atomic;

    //PS:source是一个thimble【顶针】,其不缠在任何逻辑，只占个坑
    Operator source;

    Operator current;

    public static OperatorChain newInstance(){

        Operator thimble = Operator.thimble();

        OperatorChain operatorChain = new OperatorChain();

        operatorChain.setSource(thimble);

        return operatorChain;
    }


    public boolean hasNext(){
        if (current == null)
            current = source;

        return current.next.isPresent();
    }

    public Operator next(){

        current = source.next.get();
        return current;
    }

    public Operator last(){
        while (hasNext()){
            next();
        }
        return current;
    }


}
