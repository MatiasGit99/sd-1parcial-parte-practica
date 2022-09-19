    package py.una.server.udp;


import java.io.*;
import java.net.*;


import py.una.entidad.SensoresMeteorologicos;
import py.una.entidad.SensoresMeteorologicosJSON1;

class UDPClient {

    public static void main(String a[]) throws Exception {

        // Datos necesario
        String direccionServidor = "127.0.0.1";

        if (a.length > 0) {
            direccionServidor = a[0];
        }

        int puertoServidor = 9876;
        
        try {

            BufferedReader inFromUser =
                    new BufferedReader(new InputStreamReader(System.in));

            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName(direccionServidor);
            System.out.println("Intentando conectar a = " + IPAddress + ":" + puertoServidor +  " via UDP...");

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            System.out.println("Ingrese ID");
            String strid_estacion = inFromUser.readLine();
            Long id_estacion;
            id_estacion = Long.parseLong(strid_estacion);


            System.out.println("Ingrese ciudad");
            String ciudad = inFromUser.readLine();

            
            System.out.println("Ingrese porcentaje_humedad");
            String strporcentaje_humedad = inFromUser.readLine();
            Double porcentaje_humedad =0.0;
            porcentaje_humedad = Double.parseDouble(strporcentaje_humedad);


            
            System.out.println("Ingrese temperatura");
            String strtemperatura = inFromUser.readLine();
            Double temperatura = 0.0;
            temperatura = Double.parseDouble(strtemperatura);

            System.out.println("Ingrese velocidad_viento");
            String strvelocidad_viento = inFromUser.readLine();
            Double velocidad_viento = 0.0;
            velocidad_viento = Double.parseDouble(strvelocidad_viento);
            
          SensoresMeteorologicos p = new SensoresMeteorologicos(id_estacion, ciudad, porcentaje_humedad, temperatura, velocidad_viento);
          
            String datoPaquete = SensoresMeteorologicosJSON1.objetoString(p); 
            sendData = datoPaquete.getBytes();

            System.out.println("Enviar " + datoPaquete + " al servidor. ("+ sendData.length + " bytes)");
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, puertoServidor);

            clientSocket.send(sendPacket);

            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData, receiveData.length);

            System.out.println("Esperamos si viene la respuesta.");

            //Vamos a hacer una llamada BLOQUEANTE entonces establecemos un timeout maximo de espera
            clientSocket.setSoTimeout(10000);

            try {
                // ESPERAMOS LA RESPUESTA, BLOQUENTE
                clientSocket.receive(receivePacket);

                String respuesta = new String(receivePacket.getData());
                SensoresMeteorologicos presp = SensoresMeteorologicosJSON1.stringObjeto(respuesta.trim());
                
                InetAddress returnIPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                System.out.println("Respuesta desde =  " + returnIPAddress + ":" + port);
      

            } catch (SocketTimeoutException ste) {

                System.out.println("TimeOut: El paquete udp se asume perdido.");
            }
            clientSocket.close();
        } catch (UnknownHostException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
} 

