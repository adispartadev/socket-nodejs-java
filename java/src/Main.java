import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main extends Thread {

	public static void main(String args[]) throws InterruptedException {
		String serverName = "localhost";
		int port = 5000;
		try {
			System.out.println("Connecting to " + serverName + " on port "
					+ port);
			Socket client = new Socket(serverName, port);
			System.out.println("Just connected to "
					+ client.getRemoteSocketAddress());
			System.out.println("Say something: ");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);

			String fromServer;
			String fromUser;

			System.out.println("Client: ");
			Scanner stdIn = new Scanner(System.in);
			fromUser = stdIn.nextLine();
			if (fromUser != null) {
				System.out.println("Client: " + fromUser);
				out.println(fromUser);
			}

			while ((fromServer = in.readLine()) != null) {

				System.out.println("Server: " + fromServer);

				if (fromServer.equals("ff")) {
					System.out.println("BOOOOO");
				}else{
					System.out.println("no");
				}

				if (fromServer.equals("Bye."))
					break;

			}

		} catch (IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

}
