package com.lyao.test;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.lyao.ftp.FTPUtils;
import com.lyao.ftp.SFTPUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;

/**
 * @author lyao
 * @date 2018/6/28 17:07
 * @description
 */
public class UploadImage {

    private static String bcard_ftp_host = "10.180.29.20";
    private static Integer bcard_ftp_port = 22;
    private static String bcard_ftp_user = "busimgr";
    private static String bcard_ftp_pwd = "!QAZ2wsx";
    private static String jtt_ftp_ip = "10.37.10.13";
    private static Integer jtt_ftp_port = 21;
    private static String jtt_ftp_user = "sdgsftp";
    private static String jtt_ftp_pwd = "sdgsftp";
    private static String uploadPath = "/upload/unzip/";
    private static Logger log;

    static {
        log = Logger.getLogger(UploadImage.class);
        InputStream inputStream=UploadImage.class.getResourceAsStream("/log4j.properties");
        PropertyConfigurator.configure(inputStream);
        log.debug("启动");
    }

    public void upload(String imagePath){
        log.debug("开始");
        String msg = "";
        SFTPUtils sftpUtil = new SFTPUtils();
        ChannelSftp sftp = null;
        FTPUtils ftpUtils = new FTPUtils();
        try {
            sftp = sftpUtil.connect(bcard_ftp_host, bcard_ftp_port, bcard_ftp_user, bcard_ftp_pwd);
        } catch (JSchException e) {
            log.error("a", e);
        }
        log.debug("sftp连接成功");
        if (!ftpUtils.connect(jtt_ftp_ip, jtt_ftp_port, jtt_ftp_user, jtt_ftp_pwd)){
            msg = "连接 " + jtt_ftp_ip + "失败";
            log.error(msg);
            sftpUtil.disconnect(sftp);
        }
        log.debug("ftp连接成功");

        InputStream inputStreamCertificate = null;
        try {
            inputStreamCertificate = sftp.get(imagePath);
        } catch (SftpException e) {
            log.error("获取图片字节流失败",e);
        }
        log.debug("开始上传");

        boolean uploadCertificate = ftpUtils.upload(uploadPath, getImageName(imagePath), inputStreamCertificate);
        if (uploadCertificate){
            log.debug("上传成功");
        }else {
            log.debug("上传失败");
        }

        sftpUtil.disconnect(sftp);
        ftpUtils.disconnect();
        log.debug("退出");
    }

    private String getImageName(String path){
        String imageName = null;
        if (StringUtils.isNotEmpty(path)){
            if (path.startsWith("/home")){
                String[] strs = path.split("/");
                imageName = strs[strs.length-1];
            }
        }
        return imageName;
    }
    public static void main(String[] args) {
        UploadImage uploadImage = new UploadImage();
        System.out.println(args[0]);
        uploadImage.upload(args[0]);
    }
}
