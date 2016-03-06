package com.zehao.action;

import java.io.File;
import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;

import com.zehao.util.FileUtil;

public class UploadImageAction extends BaseAction {

	private static final long serialVersionUID = 8402211594815952606L;

	private File upload;

	private String name;

	private String user;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@SuppressWarnings("deprecation")
	public void uploadImage() {
		try {
			// 解码URLDecoder.decode(name, "utf-8")
			// 编码URLEncoder.encode(name, "utf-8")
			logger.info("开始上传图片......");
			String image_folder_path = ServletActionContext.getRequest()
					.getRealPath("/image");
			StringBuffer image_file_path = new StringBuffer(image_folder_path)
					.append("/").append(user).append("_")
					.append(URLDecoder.decode(name, "utf-8"));
			Boolean sign = FileUtil.copy(upload, image_file_path.toString());
			logger.info("图片上传结束......" + sign);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("上传图片出错：" + e.toString());
		}
	}

}
