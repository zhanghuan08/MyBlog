package com.codehuan.utils;

import com.codehuan.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
 * @author ZhangHuan created on 2021/2/9
 */
public class ShiroUtil {

    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
