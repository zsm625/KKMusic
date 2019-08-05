package cn.com.zx221.javaweb.po;

import java.sql.Timestamp;

public class CdPo {
	private int cd_id;
	private String cd_name;
	private String cd_coverUrl;
	private int cd_songCount;
	private Timestamp cd_publishDate;
	private int cd_singerId;
	private String cd_introduce;
	private int cd_collectionCount;
	private String cd_synopsis;
	private String cd_company;

	public String getCd_company() {
		return cd_company;
	}

	public void setCd_company(String cd_company) {
		this.cd_company = cd_company;
	}

	public int getCd_id() {
		return cd_id;
	}

	public void setCd_id(int cd_id) {
		this.cd_id = cd_id;
	}

	public String getCd_name() {
		return cd_name;
	}

	public void setCd_name(String cd_name) {
		this.cd_name = cd_name;
	}

	public String getCd_coverUrl() {
		return cd_coverUrl;
	}

	public void setCd_coverUrl(String cd_coverUrl) {
		this.cd_coverUrl = cd_coverUrl;
	}

	public int getCd_songCount() {
		return cd_songCount;
	}

	public void setCd_songCount(int cd_songCount) {
		this.cd_songCount = cd_songCount;
	}

	public Timestamp getCd_publishDate() {
		return cd_publishDate;
	}

	public void setCd_publishDate(Timestamp cd_publishDate) {
		this.cd_publishDate = cd_publishDate;
	}

	public int getCd_singerId() {
		return cd_singerId;
	}

	public void setCd_singerId(int cd_singerId) {
		this.cd_singerId = cd_singerId;
	}

	public String getCd_introduce() {
		return cd_introduce;
	}

	public void setCd_introduce(String cd_introduce) {
		this.cd_introduce = cd_introduce;
	}

	public int getCd_collectionCount() {
		return cd_collectionCount;
	}

	public void setCd_collectionCount(int cd_collectionCount) {
		this.cd_collectionCount = cd_collectionCount;
	}

	public String getCd_synopsis() {
		return cd_synopsis;
	}

	public void setCd_synopsis(String cd_synopsis) {
		this.cd_synopsis = cd_synopsis;
	}


}
