package semplest.server.sftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.apache.commons.io.IOUtils;
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
	private JSch jsch = null;
	private ChannelSftp sftp = null;
	private Channel channel = null;
	private Session session = null;
	private String workingDir = null;
	private byte[] hostKey = null;
	private String host = null;
	private int port = 22;
	// location of private public keys
	private final String publicKeyPath = "KeyFiles/semplest_dsa.pub";
	private final String privateKeyPath = "KeyFiles/semplest_dsa.pub";
	/**
	 * Password that grants access to private key file.
	 */
	private String privateKeyPassword = "SEMplest2012";
	/**
	 * User account login on remote server.
	 */
	private final String sshLogin;

	private static final Logger logger = Logger.getLogger(SecureFTPUsingSSH.class);

	public static void main(String[] args)
	{

		SecureFTPUsingSSH ftps = null;
		try
		{
			ftps = new SecureFTPUsingSSH("user","ftp1.post-n-track.com", null, 22);
			if (ftps.connectFTP())
			{
				ftps.setWorkingDirectory("upload");
				ftps.putFile(new File("C:test.txt"),"DestinationNane", null);
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
		catch (JSchException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public SecureFTPUsingSSH(String user, String Host, String hostKey, Integer portSSH) throws JSchException
	{
		jsch = new JSch();
		host = Host;
		sshLogin = user;
		if (hostKey != null)
		{
			this.hostKey = hostKey.getBytes();
		}
		if (portSSH != null)
		{
			this.port = portSSH;
		}
		setupSftpIdentity(jsch);

	}
	private void setupSftpIdentity(JSch jsch) throws JSchException
	{
		try
		{
			byte[] privateKey = IOUtils.toByteArray(new FileInputStream(privateKeyPath));
			byte[] publicKey = IOUtils.toByteArray(new FileInputStream(publicKeyPath));
			byte[] passphrase = privateKeyPassword.getBytes();
			jsch.addIdentity(sshLogin, privateKey, publicKey, passphrase);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public boolean connectFTP() throws IOException
	{
		try
		{
			session = jsch.getSession(sshLogin, host, port);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
			System.out.println("Connected to SFTP server");
			channel = session.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
			logger.info("Connected to " + host + " User:" + sshLogin + ": Port" + String.valueOf(port));
		}
		catch (JSchException e)
		{
			logger.error("SSH Connect Failed " + e.getMessage() + sshLogin + ":" + host + ":" + String.valueOf(port));
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
			throw new IOException("Error Could not delete file " + fileName + ": " + e.getMessage());
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
			logger.error("Disconnect error..." + e.getMessage());
			throw new IOException(e.getMessage());
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
			throw new IOException("Error in fileExists : " + e.getMessage());
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
			throw new IOException(e.getMessage());
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
			throw new IOException("Error in getting remote file : " + remoteFile + " and storing local " + localFile + ": " + e.getMessage());
		}
		return true;
	}

	public String[] getFileList(String dir) throws IOException
	{
		try
		{
			if (sftp.isConnected())
			{
				ArrayList<String> f = new ArrayList<String>();
				Vector<String> files = sftp.ls(dir);

				if (files != null)
				{

					for (int i = 0; i < files.size(); i++)
					{
						f.add(files.elementAt(i).toString());
					}
					return (String[]) f.toArray();
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
			throw new IOException("Error in getFileList for: " + dir + " : " + e.getMessage());
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
			throw new IOException("Error sending file " + localfile.getName() + " remoteFileName " + remoteFileName + ":" + e.getMessage());
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
			logger.error("renameRemoteFile " + e.getMessage());
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
			logger.error(e.getMessage());
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

	

	/*
	 * private static String help = "      Available commands:\n"+
	 * "      * means unimplemented command.\n"+
	 * "cd path                       Change remote directory to 'path'\n"+
	 * "lcd path                      Change local directory to 'path'\n"+
	 * "chgrp grp path                Change group of file 'path' to 'grp'\n"+
	 * "chmod mode path               Change permissions of file 'path' to 'mode'\n"
	 * + "chown own path                Change owner of file 'path' to 'own'\n"+
	 * "help                          Display this help text\n"+
	 * "get remote-path [local-path]  Download file\n"+
	 * "get-resume remote-path [local-path]  Resume to download file.\n"+
	 * "get-append remote-path [local-path]  Append remote file to local file\n"
	 * + "*lls [ls-options [path]]      Display local directory listing\n"+
	 * "ln oldpath newpath            Symlink remote file\n"+
	 * "*lmkdir path                  Create local directory\n"+
	 * "lpwd                          Print local working directory\n"+
	 * "ls [path]                     Display remote directory listing\n"+
	 * "*lumask umask                 Set local umask to 'umask'\n"+
	 * "mkdir path                    Create remote directory\n"+
	 * "put local-path [remote-path]  Upload file\n"+
	 * "put-resume local-path [remote-path]  Resume to upload file\n"+
	 * "put-append local-path [remote-path]  Append local file to remote file.\n"
	 * + "pwd                           Display remote working directory\n"+
	 * "stat path                     Display info about path\n"+
	 * "exit                          Quit sftp\n"+
	 * "quit                          Quit sftp\n"+
	 * "rename oldpath newpath        Rename remote file\n"+
	 * "rmdir path                    Remove remote directory\n"+
	 * "rm path                       Delete remote file\n"+
	 * "symlink oldpath newpath       Symlink remote file\n"+
	 * "readlink path                 Check the target of a symbolic link\n"+
	 * "realpath path                 Canonicalize the path\n"+
	 * "rekey                         Key re-exchanging\n"+
	 * "compression level             Packet compression will be enabled\n"+
	 * "version                       Show SFTP version\n"+
	 * "?                             Synonym for help"; }
	 */

}
