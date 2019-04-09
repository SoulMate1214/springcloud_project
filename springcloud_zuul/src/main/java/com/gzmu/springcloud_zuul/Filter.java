package com.gzmu.springcloud_zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Filter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(Filter.class);
    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     *  pre：路由之前
     *  routing：路由之时
     *  post： 路由之后
     *  error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder：过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter：这里可以写逻辑判断，是否要过滤，true,永远过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。可以很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
     * 这里是简单的通过http请求获取token令牌，并做判断
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        Object token = request.getParameter("token");
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        if(token == null) {
            log.warn("没有token，滚蛋");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                response.setContentType("text/html;charset=UTF-8");
                ctx.getResponse().getWriter().write("没有token，滚蛋");
            }catch (Exception e){

            }
            return null;
        }
        log.info("有token，进去吧");
        return null;
    }
}


