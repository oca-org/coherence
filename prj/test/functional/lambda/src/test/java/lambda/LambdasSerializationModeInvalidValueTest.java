/*
 * Copyright (c) 2000, 2021, Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * http://oss.oracle.com/licenses/upl.
 */

package lambda;


import com.tangosol.internal.util.invoke.Lambdas;

import com.tangosol.net.CacheFactory;
import common.SystemPropertyIsolation;

import org.junit.ClassRule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author jf  2020.07.27
 */
public class LambdasSerializationModeInvalidValueTest
    {
    @Test
    public void ensureInvalidLambdasSerializationModeDefaulted()
        {
        System.setProperty(Lambdas.LAMBDAS_SERIALIZATION_MODE_PROPERTY, "InvalidValue");

        boolean fProductionMode = CacheFactory.getLicenseMode().equalsIgnoreCase("prod");
        
        assertThat("ensure default mode by checking if coherence running in production mode",
                   Lambdas.isDynamicLambdas(), is(!fProductionMode));
        assertThat("ensure default mode by checking if coherence running in production mode",
                   Lambdas.isStaticLambdas(), is(fProductionMode));
        }

    /**
     * A {@link org.junit.ClassRule} to isolate system properties set between test class
     * execution (not individual test method executions).
     */
    @ClassRule
    public static SystemPropertyIsolation s_systemPropertyIsolation = new SystemPropertyIsolation();
    }