package com.navisens.yelp;

/*
 * A singleton response of Yelp auth token. 
 */
public class YelpAuthResponse {

	private String access_token;
	private String token_type;
	private long expires_in;
	private static YelpAuthResponse instance;

	private YelpAuthResponse() {
	};

	public static synchronized YelpAuthResponse getInstance() {
		if (instance == null)
			return instance = new YelpAuthResponse();

		return instance;
	}

	@Override
	public String toString() {
		return "YelpAuthResponse [access_token=" + access_token + ", token_type=" + token_type + ", expires_in="
				+ expires_in + "]";
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}
}
