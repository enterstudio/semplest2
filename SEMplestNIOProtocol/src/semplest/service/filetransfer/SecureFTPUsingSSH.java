package semplest.service.filetransfer;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
/*
 * USing SSH
 */
public class SecureFTPUsingSSH 
{
	private static final Logger logger = Logger.getLogger(SecureFTPUsingSSH.class);
	private JSch jsch = null;
	private ChannelSftp sftp = null;
	private Channel channel = null;
	private Session session = null;
	private String workingDir = null;
	private byte[] hostKey = null;
	private String host = null;
	private int port = 22;

	public static void main(String[] args)
	{
		BasicConfigurator.configure();
		SecureFTPUsingSSH ftps = new SecureFTPUsingSSH("orbitalbatchvar.paymentech.net", null,22);
		try
		{
			if (ftps.connectFTP("VNVRB7PP", "KWLT3LTB"))
			{
				
				ftps.getFile("ClosedBatchSummaryRpt_211416_09242012_094834_155938_resp.csv.ASC", "c:/ClosedBatchSummaryRpt_211416_09242012_094834_155938_resp.csv.ASC", null);
				
				
				try
				{
					String[] l = ftps.getFileList("/files");
					for (int i = 0; i < l.length; i++)
					{
						System.out.println(l[i]);
					}
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				ftps.disconnectFTP();
				logger.info("Done SSH");
				return;
				
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (ftps != null)
			{
				try
				{
					ftps.disconnectFTP();
				}
				catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}
	public SecureFTPUsingSSH(String Host,String hostKey, Integer portSSH)
	{
		jsch = new JSch();
		host = Host;
		if (hostKey != null)
		{
			this.hostKey = hostKey.getBytes();
			//HostKey h = new HostKey(host,this.hostKey);
		}
		if (portSSH != null)
		{
			this.port = portSSH;
		}
		
	}

	
	public boolean connectFTP(String user, String pass) throws IOException
	{
		try
		{
			session = jsch.getSession(user, host, port);
			// NEED TO WORK ON HOST KEY
			if (hostKey == null)
			{
				session.setConfig("StrictHostKeyChecking", "no");
			}
			else
			{
				//don't know how to set hostkey file
			}
			session.setPassword(pass);
			session.connect();
			channel = session.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
			logger.info("Connected to " + host + " User:" + user + ": Port" + String.valueOf(port));
		}
		catch (JSchException e)
		{
			logger.error("SSH Connect Failed " + e.getMessage() + user + ":" +  host + ":" + String.valueOf(port), e );
			return false;
		}
		return true;
	}

	
	public boolean deleteFile(String fileName) throws IOException
	{
		try
		{
			if (sftp.isConnected())
			{
				sftp.rm(fileName);
				logger.info("Deleted File : " + fileName);
			}
			else
			{
				logger.error("SFTP Not Connected");
				return false;
			}
		}
		catch (SftpException e)
		{
			throw new IOException("Error Could not delete file " + fileName + ": " + e.getMessage(), e);
		}
		return true;
	}

	
	public void disconnectFTP() throws IOException
	{
		try
		{
			if (sftp.isConnected())
			{
				channel.disconnect();
  		      	session.disconnect();
				sftp.disconnect();
				sftp = null;
				jsch = null;
				logger.info("DISCONNECTED");
			}
			else
			{
				logger.debug("FTP Already disconnected");
			}
		}
		catch (Exception e)
		{
			logger.error("Disconnect error..." + e.getMessage(), e);
			throw new IOException(e.getMessage(), e);
		}
	}

	
	public boolean fileExists(String remoteDir, String remoteFileName) throws IOException
	{
		try
		{
			String[] files = getFileList(remoteDir);
			if (files != null)
			{
				for (int i = 0; i < files.length; i++)
				{
					if (files[i].equalsIgnoreCase(remoteFileName))
					{
						return true;
					}
				}
			}
		}
		catch (IOException e)
		{
			throw new IOException("Error in fileExists : " + e.getMessage(), e);
		}
		return false;
	}

	
	public boolean fileWait(String remoteDir, String remoteFileName, int maxWait) throws IOException
	{
		// TODO Auto-generated method stub
		return false;
	}

	
	public void ftpQuit() throws IOException
	{
		try
		{
			if (sftp != null)
			{
				sftp.quit();
				logger.info("Secure FTP Quit");
			}
		}
		catch (Exception e)
		{
			throw new IOException(e.getMessage(), e);
		}

	}

	
	public boolean getFile(String remoteFile, String localFile, String filetype) throws IOException
	{
		try
		{
			if (sftp.isConnected())
			{
				sftp.get(remoteFile, localFile);
				logger.info("Retrieved File " + remoteFile + " To " + localFile);
			}
			else
			{
				logger.error("SFTP Not Connected");
				return false;
			}
		}
		catch (SftpException e)
		{
			throw new IOException("Error in getting remote file : " + remoteFile + " and storing local " + localFile + ": " + e.getMessage(), e);
		}
		return true;
	}

	
	public String[] getFileList(String dir) throws IOException
	{
		try
		{
			if (sftp.isConnected())
			{
				List<String> f = new ArrayList<String>();
				Vector files = sftp.ls(dir);
				
				if (files != null)
				{

					
					for (int i = 0; i < files.size(); i++)
					{
						Object obj=files.elementAt(i);               
						if(obj instanceof com.jcraft.jsch.ChannelSftp.LsEntry)
						{
							f.add(((com.jcraft.jsch.ChannelSftp.LsEntry)obj).getFilename());
						}
						
					}
					return f.toArray(new String[0]);
				}
				else
				{
					return null;
				}
			}
			else
			{
				logger.error("SFTP Not Connected");
				return null;
			}
		}
		catch (SftpException e)
		{
			throw new IOException("Error in getFileList for: " + dir + " : " + e.getMessage(), e);
		}
	}

	
	public boolean isConnected()
	{
		if (sftp != null)
		{
			return sftp.isConnected();
		}
		else
		{
			return false;
		}
	}

	
	public int listFiles(String dir, String targetFileName) throws IOException
	{
		try
		{
			if (sftp.isConnected())
			{
				if (dir == null)
				{
					sftp.cd(dir);
					String[] files = getFileList(dir);
					if (files != null)
					{
						if (targetFileName == null)
						{
							return files.length;
						}
						else
						{
							for (int i = 0; i < files.length; i++)
							{
								if (files[i] != null)
								{
									logger.info("Remote File #" + 1 + " :" + files[i]);
									if (files[i].equalsIgnoreCase(targetFileName))
									{
										logger.info(targetFileName + " Found");
										resetToHomeDirectory();
										return 1;
									}
								}
							}
							resetToHomeDirectory();
							return 0; // NOT FOUND
						}
					}
					else
					{
						resetToHomeDirectory();
						return 0;
					}
				}
				else
				{
					logger.info("Working Directory " + dir + " Does not exist");
					resetToHomeDirectory();
					return -1;
				}
			}
			else
			{
				logger.info("SFTP not connected");
				resetToHomeDirectory();
				return -1;
			}
		}
		catch (SftpException e)
		{
			logger.error(e.getMessage());
			throw new IOException(e.getMessage());
		}
	}

	private void resetToHomeDirectory() throws SftpException
	{
		try
		{
			logger.debug("Set the WorkingDirectory /");
			sftp.cd("/");
		}
		catch (SftpException e)
		{
			throw e;
		}
	}

	
	public boolean putFile(File localfile, String remoteFileName, String filetype) throws IOException
	{
		try
		{
			if (isConnected() && localfile.exists())
			{
				sftp.put(localfile.getAbsolutePath(), remoteFileName);
				logger.info("Successfully Copied File " + localfile.getAbsolutePath() + " to  " + remoteFileName);
				return true;
			}
			else
			{
				if (!localfile.exists())
				{
					logger.info("Local file " + localfile.getAbsolutePath() + " Does not exist");
				}
				else
				{
					logger.info("NOT Connected");
				}
				return false;

			}
		}
		catch (SftpException e)
		{
			throw new IOException("Error sending file " + localfile.getName() + " remoteFileName " + remoteFileName + ":" + e.getMessage(), e);
		}
	}

	public boolean renameRemoteFile(String from, String to) throws IOException
	{
		try
		{
			if (isConnected())
			{
				sftp.rename(from, to);
				logger.info("rename RemoteFile " + from + " To " + to);
				return true;
			}
			else
			{
				logger.info("NOT CONNECTED");
				return false;
			}
		}
		
		catch (SftpException e)
		{
			logger.error("renameRemoteFile " + e.getMessage(), e);
			throw new IOException(e.getMessage());
		}
	}

	public boolean remoteFileExists(String remoteDir, String remoteFileName) throws IOException
	{
		try
		{
			if (listFiles(remoteDir, remoteFileName) == 1)
			{
				return true;
			}
			else
			{
				return false;
			}

		}
		catch (IOException e)
		{
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	
	public void setFileType(String type) throws IOException
	{
		// TODO Auto-generated method stub

	}

	
	public boolean setWorkingDirectory(String workingDir)
	{
		try
		{
			if (!isConnected())
			{
				logger.info("Failed to Change Directories - Not Connected");
				return false;
			}
			else if (workingDir == null)
			{
				return true;
			}
			else
			{
				sftp.cd(workingDir);
				this.workingDir = workingDir;
				logger.info("Set Working Directory to: " + workingDir);

				return true;
			}
		}
		catch (SftpException e)
		{
			logger.info("Failed to Change Directories " + e.getMessage());
			return false;
		}
	}

}
