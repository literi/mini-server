//package work.spacestime.admin.security;
//
//import java.io.BufferedReader;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//
//import cn.hutool.core.util.ObjectUtil;
//import cn.hutool.http.HttpRequest;
//import cn.hutool.json.JSON;
//import cn.hutool.json.JSONObject;
//import cn.hutool.json.JSONUtil;
//
//
//public class AuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {
//
//    public WxAppletAuthenticationFilter(String defaultFilterProcessesUrl) {
//        super(defaultFilterProcessesUrl);
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
//        String method = httpServletRequest.getMethod().toUpperCase();
//        if (!"POST".equals(method)) {
////            throw new UnSupportMethodException(method);
//        	throw new Error("Error request Method!");
//        }
//        String contentType = httpServletRequest.getContentType().toLowerCase();
//        if ("application/json;charset=utf-8".equals(contentType)) {
////            throw new UnSupportContentTypeException(contentType);
//            throw new Error("Error request contentType!");
//        }
//        // body参数转换为json
//        StringBuffer sb = new StringBuffer();
//        String line = null;
//        BufferedReader reader = httpServletRequest.getReader();
//        while ((line = reader.readLine()) != null) {
//        	sb.append(line);
//        }
//            
//
//        String jsonString = sb.toString().replaceAll("\\s", "").replaceAll("\n", "");
//        JSONObject jsonObject = JSONUtil.parseObj(jsonString);
//
//        // 取出code
//        String code = jsonObject.get("code", String.class);
//        if (ObjectUtil.isEmpty(code)) {
//            throw new Error("error wx opencode");
//        }
//        String role = jsonObject.get("role", String.class);
//        if (ObjectUtil.isEmpty(role)) {
//        	throw new Error("error wx role");
////            throw new MissingParameterException("role");
//        }
//        
//        Map<String, String> data = new HashMap<String, String>();
//        data.put("appid", "xxxxxxxxxxxxxxxxx");
//        data.put("secret", "eeeeeeeeeeeeeeeeeeeeeeeeee");
//        data.put("js_code", code);
//        data.put("grant_type", "authorization_code");
//
//
//        String response = HttpRequest.get("https://api.weixin.qq.com/sns/jscode2session").form().body();
//        System.out.println("Response was: " + response);
////        JSONObject obj= JSON.parseObject(response);//将json字符串转换为json对
////        System.out.println(obj);
////        JSONObject session = WeChatUtils.code2Session(code);
//
////        String openId = session.get("openid", String.class);
////        String sessionKey = session.get("session_key", String.class);
//
//        Object openId;
//		Object sessionKey;
//		if (ObjectUtil.isEmpty(openId) || ObjectUtil.isEmpty(sessionKey)) {
//            throw new RuntimeException("无法获取openId");
//        }
//
//        return this.getAuthenticationManager().authenticate(new WxAppletAuthenticationToken(openId, sessionKey , role));
//    }
//}
