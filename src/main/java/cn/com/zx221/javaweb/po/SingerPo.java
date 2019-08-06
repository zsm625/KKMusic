package cn.com.zx221.javaweb.po;

import java.sql.Timestamp;

public class SingerPo {
    private int singer_id;
    private String singer_name;
    private int singer_accessCount;
    private int singer_collection;
    private String singer_areaId;
    private String singer_introduce;
    private Timestamp singer_birthday;
    private String singer_photoUrl;
    private String singer_sex;
    private String singer_initial;
    private String singer_type;
	public int getSinger_id() {
		return singer_id;
	}
	public void setSinger_id(int singer_id) {
		this.singer_id = singer_id;
	}
	public String getSinger_name() {
		return singer_name;
	}
	public void setSinger_name(String singer_name) {
		this.singer_name = singer_name;
	}
	public int getSinger_accessCount() {
		return singer_accessCount;
	}
	public void setSinger_accessCount(int singer_accessCount) {
		this.singer_accessCount = singer_accessCount;
	}
	public int getSinger_collection() {
		return singer_collection;
	}
	public void setSinger_collection(int singer_collection) {
		this.singer_collection = singer_collection;
	}
	public String getSinger_areaId() {
		return singer_areaId;
	}
	public void setSinger_areaId(String singer_areaId) {
		this.singer_areaId = singer_areaId;
	}
	public String getSinger_introduce() {
		return singer_introduce;
	}
	public void setSinger_introduce(String singer_introduce) {
		this.singer_introduce = singer_introduce;
	}
	public Timestamp getSinger_birthday() {
		return singer_birthday;
	}
	public void setSinger_birthday(Timestamp singer_birthday) {
		this.singer_birthday = singer_birthday;
	}
	public String getSinger_photoUrl() {
		return singer_photoUrl;
	}
	public void setSinger_photoUrl(String singer_photoUrl) {
		this.singer_photoUrl = singer_photoUrl;
	}
	public String getSinger_sex() {
		return singer_sex;
	}
	public void setSinger_sex(String singer_sex) {
		this.singer_sex = singer_sex;
	}
	public String getSinger_initial() {
		return singer_initial;
	}
	public void setSinger_initial(String singer_initial) {
		this.singer_initial = singer_initial;
	}
	public String getSinger_type() {
		return singer_type;
	}
	public void setSinger_type(String singer_type) {
		this.singer_type = singer_type;
	}
    
}
