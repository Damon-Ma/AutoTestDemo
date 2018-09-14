package com.damon.functons;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyPlusDemo extends AbstractFunction {

    private Object[] valuse;
    private CompoundVariable first,second;

    /**
     * 执行方法
     * @param sampleResult
     * @param sampler
     * @return
     * @throws InvalidVariableException
     */
    public String execute(SampleResult sampleResult, Sampler sampler) throws InvalidVariableException {
        first = (CompoundVariable) valuse[0];
        second = (CompoundVariable) valuse[1];
        int count = new Integer(first.execute().trim()) + new Integer(second.execute().trim());
        System.out.println("两数之和："+count);

        //       System.out.println("This is execute");
        return String.valueOf(count);
    }

    /**
     * 设置参数，接收用户传递的参数
     * @param collection
     * @throws InvalidVariableException
     */
    public void setParameters(Collection<CompoundVariable> collection) throws InvalidVariableException {
        checkParameterCount(collection,2);
        valuse = collection.toArray();
        System.out.println("This is setParameter");
    }

    /**
     * 功能名称
     * @return
     */
    public String getReferenceKey() {
        System.out.println("This is getReferenceKey");
        return "__MyPlusDemo";
    }

    /**
     * 功能描述，参数描述
     * @return
     */
    public List<String> getArgumentDesc() {
        System.out.println("This is getArgumentDesc");
        List desc = new ArrayList();
        desc.add("第一个数");
        desc.add("第二个数");
        return desc;
    }
}
