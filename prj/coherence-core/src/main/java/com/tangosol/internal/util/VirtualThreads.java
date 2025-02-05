/*
 * Copyright (c) 2000, 2023, Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * https://oss.oracle.com/licenses/upl.
 */

package com.tangosol.internal.util;

import com.tangosol.util.Base;

/**
 * Helper class for virtual threads functionality.
 * <p>
 * The main purpose of this class is to isolate the code that uses virtual threads
 * (Loom) APIs, in order to simplify multi-release JAR creation.
 *
 * @author Aleks Seovic  2023.06.08
 * @since 23.09
 */
public class VirtualThreads
    {
    /**
     * Create a virtual thread with the specified runnable, and name.
     *
     * @param group     (optional) the thread's thread group
     * @param runnable  (optional) the thread's runnable
     * @param sName     (optional) the thread's name
     *
     * @return a new thread using the specified parameters
     */
    public static Thread makeThread(ThreadGroup group, Runnable runnable, String sName)
        {
        return Base.makeThread(group, runnable, sName);
        }
    }
