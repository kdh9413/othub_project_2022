package partner;

import org.springframework.web.multipart.MultipartFile;

public class OCRDTO {
	int ocr_id;
	MultipartFile ocr_img;
	String m_id, ocr_imgname, ocr_uploadtime;
	
	
	public int getOcr_id() {
		return ocr_id;
	}
	public void setOcr_id(int ocr_id) {
		this.ocr_id = ocr_id;
	}
	public MultipartFile getOcr_img() {
		return ocr_img;
	}
	public void setOcr_img(MultipartFile ocr_img) {
		this.ocr_img = ocr_img;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getOcr_imgname() {
		return ocr_imgname;
	}
	public void setOcr_imgname(String ocr_imgname) {
		this.ocr_imgname = ocr_imgname;
	}
	public String getOcr_uploadtime() {
		return ocr_uploadtime;
	}
	public void setOcr_uploadtime(String ocr_uploadtime) {
		this.ocr_uploadtime = ocr_uploadtime;
	}
	
	
	
	
	
}
