package com.shri.ruleengine.context;

import org.springframework.core.NamedInheritableThreadLocal;

public class AppRequestContextHolder {
    private static final ThreadLocal<AppRequestContext> REQUEST_CONTEXT_THREAD_LOCAL =
            new NamedInheritableThreadLocal<>("App Request Context");

    /**
     * Stores/put the requestContext in the ThreadLocal
     *
     * @param requestContextParam the requestContext
     */
    public static void setRequestContext(AppRequestContext requestContextParam)
    {
        REQUEST_CONTEXT_THREAD_LOCAL.set(requestContextParam);
    }

    /**
     * Retrieves the requestContext from the ThreadLocal.
     *
     * @return AppRequestContext the requestContext
     */
    public static AppRequestContext getRequestContext()
    {
        AppRequestContext requestContext = REQUEST_CONTEXT_THREAD_LOCAL.get();
        return requestContext;
    }

    /**
     * removes the requestContext from the ThreadLocal.
     *
     */
    public static void resetRequestContext()
    {
        REQUEST_CONTEXT_THREAD_LOCAL.remove();
    }

}
