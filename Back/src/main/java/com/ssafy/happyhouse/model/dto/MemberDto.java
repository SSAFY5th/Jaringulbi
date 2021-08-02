package com.ssafy.happyhouse.model.dto;
import java.sql.Timestamp;
public class MemberDto {
    private String userid;
    private String passwd;
    private String username;
    private String nickname;
    private String address;
    private String addressdetail;
    private String interdongcode;
    private String email;
    private String phone;
    private Timestamp regidate;
    @Override
	public String toString() {
		return "MemberDto [userid=" + userid + ", passwd=" + passwd + ", username=" + username + ", nickname="
				+ nickname + ", address=" + address + ", addressdetail=" + addressdetail + ", interdongcode=" + interdongcode
				+ ", email=" + email + ", phone=" + phone + ", regidate=" + regidate + "]";
	}

    public MemberDto() {}
    public MemberDto(String userid, String passwd, String username, String nickname, String address, String addressdetail, String interdongcode, String email, String phone) {
    	this.userid = userid;
    	this.passwd = passwd;
    	this.username = username;
    	this.nickname = nickname;
    	this.address = address;
    	this.addressdetail = addressdetail;
    	this.interdongcode = interdongcode;
    	this.email = email;
    	this.phone = phone;
    }
    
    public void setUserid(String userid) { 
        this.userid = userid;
    }

    public String getUserid() { 
        return userid;
    }

    public void setPasswd(String passwd) { 
        this.passwd = passwd;
    }

    public String getPasswd() { 
        return passwd;
    }

    public void setUsername(String username) { 
        this.username = username;
    }

    public String getUsername() { 
        return username;
    }

    public void setNickname(String nickname) { 
        this.nickname = nickname;
    }

    public String getNickname() { 
        return nickname;
    }

    public void setAddress(String address) { 
        this.address = address;
    }

    public String getAddress() { 
        return address;
    }

    public void setAddressdetail(String addressdetail) { 
        this.addressdetail = addressdetail;
    }

    public String getAddressdetail() { 
        return addressdetail;
    }

    public String getInterdongcode() {
		return interdongcode;
	}

	public void setInterdongcode(String interdongcode) {
		this.interdongcode = interdongcode;
	}

	public void setEmail(String email) { 
        this.email = email;
    }

    public String getEmail() { 
        return email;
    }

    public void setPhone(String phone) { 
        this.phone = phone;
    }

    public String getPhone() { 
        return phone;
    }

    public void setRegidate(Timestamp regidate) { 
        this.regidate = regidate;
    }

    public Timestamp getRegidate() { 
        return regidate;
    }
}