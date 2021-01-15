package com.lyao.ftp;

import com.jcraft.jsch.*;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;
import java.util.Vector;

public class SFTPUtils
{
    private static Logger log = Logger.getLogger(SFTPUtils.class);
    private static Session sshSession;

    public ChannelSftp connect(String host, int port, String username, String password) throws JSchException
    {
        JSch jsch = new JSch();
        jsch.getSession(username, host, port);
        sshSession = jsch.getSession(username, host, port);
        log.debug("Session created.");
        sshSession.setPassword(password);
        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        sshSession.setConfig(sshConfig);
        sshSession.connect();
        log.debug("Session connected.");
        log.info("Opening Channel.");
        Channel channel = sshSession.openChannel("sftp");
        channel.connect();
        ChannelSftp sftp = (ChannelSftp) channel;
        log.info("Connected to " + host + ".");
        return sftp;
    }

    public void disconnect(ChannelSftp sftp)
    {
        if (sftp != null)
        {
            if (sftp.isConnected())
            {
                sftp.disconnect();
                log.debug("Connection disconnect");
            }
            else if (sftp.isClosed())
            {
                log.debug("Connection already disconnected");
            }
        }
        if ((sshSession != null) && (sshSession.isConnected()))
        {
            sshSession.disconnect();
        }
        log.debug("disconnect");
    }

    /**
     * 上传文件
     *
     * @param directory：远程目录
     * @param sftpName：远程文件名
     * @param uploadFile：准备上传的文件
     * @param sftp
     * @throws SftpException
     * @throws FileNotFoundException
     */
    public void upload(String directory, String sftpName, String uploadFile, ChannelSftp sftp) throws SftpException, FileNotFoundException, IOException
    {
        InputStream in = null;
        try
        {
            sftp.cd(directory);
            File file = new File(uploadFile);
            in = new FileInputStream(file);
            sftp.put(in, sftpName);
        }
        finally
        {
            if (in != null)
            {
                in.close();
            }
        }
    }

    /**
     * 下载文件
     *
     * @param directory：远程目录
     * @param downloadFile：远程文件名
     * @param saveFile：下载到本地的文件("路径/文件名称")
     * @param sftp
     * @throws SftpException
     * @throws FileNotFoundException
     */
    public void download(String directory, String downloadFile, String saveFile, ChannelSftp sftp) throws SftpException, FileNotFoundException, IOException
    {
        OutputStream out = null;
        try
        {
            sftp.cd(directory);
            File file = new File(saveFile);
            out = new FileOutputStream(file);
            sftp.get(downloadFile, out);
        }
        finally
        {
            if (out != null)
            {
                out.close();
            }
        }
    }

    /**
     * 删除远程目录下的文件
     *
     * @param directory：远程目录
     * @param deleteFile：远程文件名称
     * @param sftp
     * @throws SftpException
     */
    public void delete(String directory, String deleteFile, ChannelSftp sftp) throws SftpException
    {
        sftp.cd(directory);
        sftp.rm(deleteFile);
    }

    public Vector listFiles(String directory, ChannelSftp sftp) throws SftpException
    {
        return sftp.ls(directory);
    }

    public static void main(String[] args)
    {
        try
        {
            SFTPUtils sftpUtil = new SFTPUtils();
            ChannelSftp sftp = sftpUtil.connect("10.180.26.14", 22, "uniint", "!QAZ2wsx");
            sftpUtil.download("/home/uniint/", "uniint.war", "c:\\uniint.war", sftp);
            sftpUtil.disconnect(sftp);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
