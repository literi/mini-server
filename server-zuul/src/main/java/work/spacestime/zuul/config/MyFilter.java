package work.spacestime.zuul.config;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;


import io.jsonwebtoken.*;

@Component
public class MyFilter extends ZuulFilter {
	private static final String SECRET = "MI%4567&*07-878sad546798sahd";

    private static Logger log=LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return "pre"; // 定义filter的类型，有pre、route、post、error四种
    }

    @Override
    public int filterOrder() {
        return 0; // 定义filter的顺序，数字越小表示顺序越高，越先执行
    }

    @Override
    public boolean shouldFilter() {
        return true; // 表示是否需要执行该filter，true表示执行，false表示不执行
    }

    @Override
    public Object run() throws ZuulException {
        // filter需要执行的具体操作
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        String token = getToken(request);
//        System.out.println(token);
//        System.out.println(isTokenExpired(token));
//        if(!isTokenExpired(token)) {
//        	 log.warn("there is no request token");
//             ctx.setSendZuulResponse(false);
//             ctx.setResponseStatusCode(401);
//             try {
//                 ctx.getResponse().getWriter().write("there is no request token or it is time out!");
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//             return null;
//        }else {
//        	 log.info("ok");
    	// 开发不做校验
             return null;
//        }
       
    }
    
    public static String getToken(HttpServletRequest request) {
    	String token = request.getHeader("Authorization");
        String tokenHead = "Bearer ";
        if(token == null) {
        	token = request.getHeader("token");
        } else if(token.contains(tokenHead)){
        	token = token.substring(tokenHead.length());
        } 
        if("".equals(token)) {
        	token = null;
        }
        return token;
    }
    public static Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            System.out.println(new Date().getTime());
            System.out.println("================================");
            System.out.println();
//            return expiration.before(new Date());
            return expiration.getTime() > new Date().getTime();
        } catch (Exception e) {
        	System.out.println(e);
            return false;
        }
    }

    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
        	System.out.println(e);
            claims = null;
        }
        return claims;
    }
}