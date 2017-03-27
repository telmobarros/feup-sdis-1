package server.task.commonPeer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import server.main.Peer;
import utils.Utils;

public class GetChunk implements Runnable{
	
	public static void main(String[] args) throws IOException {
		
	}
	
	private int senderID;
	private String fileID;
	private int chunkNumber;
	
	public GetChunk(int senderID,String fileID,int chunkNumber){
		this.senderID = senderID;
		this.fileID = fileID;
		this.chunkNumber = chunkNumber;
	}

	@Override
	public void run() {
		//Creating GETCHUNK msg
		//GETCHUNK <Version> <SenderId> <FileId> <ChunkNo> <CRLF><CRLF>
		byte[] msg = new String("GETCHUNK"+Utils.Space+this.senderID+Utils.Space+this.senderID+Utils.Space+this.chunkNumber+Utils.Space+Utils.CRLF+Utils.CRLF).getBytes();
		InetAddress mcGroup;
		DatagramPacket sendCommand = new DatagramPacket(msg,msg.length);
		

		try {
			mcGroup = InetAddress.getByName(Peer.mcAddress);
			DatagramSocket socket = new DatagramSocket(Peer.mcPort);
			socket.send(sendCommand);
			//TODO
			// Receive chunk msg from MDR channel
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
