package com.damon.test;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class FirstTest extends AbstractJavaSamplerClient {
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        System.out.println("Hello Jmeter!");
        return null;
    }
}
