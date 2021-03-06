package com.chengwei.action;

import com.chengwei.service.UserService;
import com.common.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chengwei
 * @date 2018/4/28 14:39
 */
@Controller
//@ResponseBody
@RequestMapping("/register")
public class RegisterAction {
    @Resource
    private UserService userService;

    @RequestMapping("/checkAccount")
    public String checkAccount(String userAccount, HttpServletRequest request){
        if(StringUtils.isEmpty(userAccount)){
            request.setAttribute("errorMsg", "参数为空！");
            return "register";
        }

        int count = userService.countByUserAccount(userAccount);
        if(count>0){
            request.setAttribute("errorMsg", "用户名重复！");
            return "register";
        }
        return "register";
    }
}
