package org.telecom.common;

/**
 * 通过ThreadLocal来获取当前用户id
 */
public class ThreadLocalUtil
{
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static Long getThreadLocalId()
    {
        return threadLocal.get();
    }

    public static void setThreadLocalId(Long id)
    {
        threadLocal.set(id);
    }

    public static void remove()
    {
        threadLocal.remove();
    }
}
