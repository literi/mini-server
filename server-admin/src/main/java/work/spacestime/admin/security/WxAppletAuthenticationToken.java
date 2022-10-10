package work.spacestime.admin.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class WxAppletAuthenticationToken extends AbstractAuthenticationToken {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String openId;
	    private Long userId;
	    private String sessionKey;
	    private String rawData;
	    private String signature;
	    private String role;

	    // 使用openid和sessionKey创建一个未验证的token
	    public WxAppletAuthenticationToken(String openId, String sessionKey, String role) {
	        super(null);
	        this.openId = openId;
	        this.sessionKey = sessionKey;
	        this.setRole(role);
	    }

	    // 使用openid和sessionKey创建一个已验证的token
	    public WxAppletAuthenticationToken(String openId, String sessionKey, Long userId, Collection<? extends GrantedAuthority> authorities) {
	        super(authorities);
	        this.openId = openId;
	        this.setUserId(userId);
	        this.sessionKey = sessionKey;
	        super.setAuthenticated(true);
	    }

	    // 使用openid创建一个已验证的token
	    public WxAppletAuthenticationToken(String openId, Long userId, Collection<? extends GrantedAuthority> authorities) {
	        super(authorities);
	        this.openId = openId;
	        this.setUserId(userId);
	        super.setAuthenticated(true);
	    }

	    @Override
	    public Object getCredentials() {
	        return this.openId;
	    }

	    @Override
	    public Object getPrincipal() {
	        return this.sessionKey;
	    }

	    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
	        if (isAuthenticated) {
	            throw new IllegalArgumentException(
	                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
	        }

	        super.setAuthenticated(false);
	    }

	    @Override
	    public void eraseCredentials() {
	        super.eraseCredentials();
	    }

		public String getSignature() {
			return signature;
		}

		public void setSignature(String signature) {
			this.signature = signature;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getRawData() {
			return rawData;
		}

		public void setRawData(String rawData) {
			this.rawData = rawData;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
}
