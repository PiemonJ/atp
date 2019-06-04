package com.flute.atp.domain.model.runtime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

    public AtomicBoolean atomic = new AtomicBoolean(false);

    //PS:source是一个thimble【顶针】,其不缠在任何逻辑，只占个坑
    Operator source;

    Operator current;

    private List<Operator> operators;

    public static OperatorChain newInstance(){

        Operator thimble = Operator.thimble();

        OperatorChain operatorChain = new OperatorChain();

        operatorChain.setSource(thimble);

        return operatorChain;
    }

    public OperatorChainIterator iterator(){
        if (!atomic.get()){
            //Init
            operators = recursion(new ArrayList<Operator>(),source);
        }
        return new OperatorChainIterator(operators);


    }


    /**
     *
     * @param ops
     * @param op
     */
    private List<Operator> recursion(List<Operator> ops,Operator op){
        if (op.next.isPresent()){
            Operator next = op.next.get();
            ops.add(next);
            recursion(ops, next);
        }
        return ops;
    }


//    private boolean hasNext(){
//        if (current == null)
//            current = source;
//
//        return current.next.isPresent();
//    }
//
//    private Operator next(){
//
//        current = source.next.get();
//        return current;
//    }

    public Operator last(){
        return recursion(source);

    }

    public Operator recursion(Operator op){

        if (op.next.isPresent()){
            return recursion(op.next.get());
        } else {
            return op;
        }

    }

    public class OperatorChainIterator{

        List<Operator> operators;

        Iterator<Operator> iterator;

        public OperatorChainIterator(List<Operator> operators) {
            this.operators = operators;
            iterator = operators.iterator();
        }

        public boolean hasNext(){
            return iterator.hasNext();
        }

        public Operator next(){
            return iterator.next();
        }
    }


}
