package com.zehao.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class FileUtil {

	/**
	 * 把文件压缩成zip格式
	 * 
	 * @param out
	 * @param f
	 * @param base
	 * @throws Exception
	 */
	public static void zip(ZipOutputStream out, File f, String base)
			throws Exception {
		System.out.println("zipping " + f.getAbsolutePath());
		if (f.isDirectory()) {
			File[] fc = f.listFiles();
			if (base != null)
				out.putNextEntry(new ZipEntry(base + "/"));
			base = base == null ? "" : base + "/";
			for (int i = 0; i < fc.length; i++) {
				zip(out, fc[i], base + fc[i].getName());
			}
		} else if (f.exists() && f.getName().endsWith(".mdb")) {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			byte[] b = new byte[1024 * 1024];
			while (in.read(b) != -1)
				out.write(b);
			in.close();
		}
	}

	/**
	 * 将一个空白的文件拷贝到指定的目录文件夹
	 * 
	 * @param fileFrom空白文件的绝对路径
	 * @param fileTo将文件复制到位置的绝对路径
	 * @return
	 */
	public static boolean copy(String fileFrom, String fileTo) {
		try {
			FileInputStream in = new FileInputStream(fileFrom);
			FileOutputStream out = new FileOutputStream(fileTo);
			byte[] bt = new byte[20480];
			int count;
			while ((count = in.read(bt)) > 0) {
				out.write(bt, 0, count);
			}
			in.close();
			out.close();
			return true;
		} catch (IOException ex) {
			System.out.println("---------- 复制文件出错：" + ex.toString()
					+ " ----------");
			return false;
		}
	}

	/**
	 * 递归删除目录下的所有文件及子目录下所有文件
	 * 
	 * @param dir
	 * @return
	 */
	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			// 递归删除目录中的子目录下
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}

}
