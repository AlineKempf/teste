/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Aline
 */
public class Converter {

    public static void main(String[] args) throws Exception {
      Socket socket;
      BufferedReader in;
      PrintWriter out;
      BufferedReader inReader;
      String mensagemEnviar;

      /* Pegar parametros */
      String nomeServidor = "10.40.7.53";
      String numeroPorta = "8080";

      /* Inicializacao de socket TCP */
      socket = new Socket(nomeServidor, new Integer(numeroPorta).intValue());

      /* Inicializacao dos fluxos de entrada e saida */
      in = new BufferedReader(new InputStreamReader
          (socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);

      /* Abertura da entrada padrao */
      inReader = new BufferedReader(new InputStreamReader(System.in));

      System.out.print ("Informe: B para converter de Decimal para Binario, Informe D para converter de Decimal para Binario, Informe Fim para sair ");	
      while ((mensagemEnviar = inReader.readLine()) != null){

         /* Envio da mensagem */
         out.println (mensagemEnviar);

         /* Recebimento da resposta do servidor */
         String resposta = in.readLine ();
         if (resposta == null) break;

         /* Imprime na tela o retorno */
         System.out.println ("Retornou: ["+ resposta + "]");
         System.out.print ("Msg: ");	
      }

      /* Finaliza tudo */
      out.close();
      in.close();
      socket.close();
   }
}
