package com.lyao.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import java.io.*;

public class FTPUtils
{
    private static Logger LOG = Logger.getLogger(FTPUtils.class);
    
    private FTPClient ftp;
    
    /**
     * 
     * 获得连接
     * 
     * @param addr
     * @param port
     * @param username
     * @param password
     * @return
     * @throws IOException
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public boolean connect(String addr, int port, String username, String password)
    {
        boolean result = false;
        try
        {
            
            ftp = new FTPClient();
            int reply;
            ftp.connect(addr, port);
            ftp.login(username, password);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply))
            {
                ftp.disconnect();
                LOG.info("FTP server refused connection.");
                return result;
            }
            
            result = true;
            
            LOG.info("FTP server 连接成功");
            
            return result;
        }
        catch (Exception e)
        {
            LOG.error("登录FTP服务失败！", e);
        }
        return result;
    }
    
    /**
     * 
     *  文件上传
     * 
     * @param localFile
     * @param remotePath
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public boolean upload(File localFile, String remotePath)
    {
        boolean success = false;
        InputStream input = null;
        try
        {
            // 禁用远程主机连接验证；它将帮助当获得主机的ip地址与数据连接尝试的IP地址不一致时报错的问题
            ftp.setRemoteVerificationEnabled(false);
            File file2 = new File(localFile.getPath());
            LOG.debug(" file.getPath() : " + localFile.getPath() + " | file2.getName() : " + file2.getName());
            input = new FileInputStream(file2);
            ftp.changeWorkingDirectory(remotePath);
            // 上传文件
            success = ftp.storeFile(file2.getName(), input);
            
            if (success)
            {
                
                LOG.info(file2.getName()+" 上传成功");
                return success;
            }
        }
        catch (Exception e)
        {
            LOG.error("上传失败 ", e);
        }
        finally
        {
            if (input != null)
            {
                try
                {
                    input.close();
                }
                catch (IOException e)
                {
                    
                    LOG.error("关闭流失败 ", e);
                }
            }
        }
        
        return success;
        
    }
    
    /**
     * 
     *  文件下载
     * 
     * @param remotepath
     * @param fileName
     * @param localPath
     * @throws IOException
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public boolean download(String remotepath, String fileName, String localPath)
    {
        boolean success = false;
        OutputStream is = null;
        try
        {
            // 禁用远程主机连接验证；它将帮助当获得主机的ip地址与数据连接尝试的IP地址不一致时报错的问题
            ftp.setRemoteVerificationEnabled(false);
            ftp.changeWorkingDirectory(remotepath);
            if(!localPath.endsWith("/")){
                localPath+="/";
            }
            File localFile = new File(localPath  + fileName);
            is = new FileOutputStream(localFile);
            // 下载文件
            success = ftp.retrieveFile(fileName, is);
            
            if (success)
            {
                LOG.info(fileName+"下载成功到!"+localPath);
                return success;
            }
            
        }
        catch (Exception e)
        {
            LOG.error("下载失败 ", e);
        }
        finally
        {
            if (is != null)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    
                    LOG.error("关闭流失败  ", e);
                }
            }
        }
        
        return success;
    }
    
    /**
     * 
     * 连接关闭
     * 
     * @throws IOException
     * @see [类、类#方法、类#成员]
     */
    public boolean disconnect()
    {
        boolean result = false;
        try
        {
            if (null != ftp && ftp.isConnected())
            {
                
                ftp.logout();
                ftp.disconnect();
                result = true;
                return result;
                
            }else{
                result = true;
                return result;
               
            }
            
        }
        catch (Exception e)
        {
            LOG.error("关闭FTP服务器的连接异常！", e);
        }
        return result;
    }

    /**
     * 上传SFTP服务器上的文件至交通厅FTP服务器
     * @param ftpPath 交通厅FTP服务器目录
     * @param fileName 文件名
     * @param input 字节流
     * @return
     */
    public boolean upload(String ftpPath, String fileName, InputStream input){
        boolean success = false;
        try
        {
            // 禁用远程主机连接验证；它将帮助当获得主机的ip地址与数据连接尝试的IP地址不一致时报错的问题
            ftp.setRemoteVerificationEnabled(false);
            ftp.changeWorkingDirectory(ftpPath);
            // 上传文件
            success = ftp.storeFile(fileName, input);
            if (success)
            {

                LOG.info(fileName + " 上传成功");
                return success;
            }
        }
        catch (Exception e)
        {
            LOG.error("上传失败 ", e);
        }
        finally
        {
            if (input != null)
            {
                try
                {
                    input.close();
                }
                catch (IOException e)
                {

                    LOG.error("关闭流失败 ", e);
                }
            }
        }

        return success;

    }


    public static void main(String[] args) throws Exception
    {
        FTPUtils t = new FTPUtils();
        boolean lianjie = t.connect("10.186.128.111", 21, "qaz", "   ");
        System.out.println("连接 ：" + lianjie);
        
        // 上传
      /*  File file = new File("d:\\2.gif");
        t.upload(file, "D:\\FTPServer");*/
       // t.disconnect();
        
       
          // 下载
        t.download("D:\\FTPServer", "test.txt", "D:"); 
        t.disconnect();
         
        
    }
    
}
