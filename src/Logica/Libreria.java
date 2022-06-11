/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author jhamilr
 */
public class Libreria {
   public static String getHoraActual() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    public static String getFechaActual() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(Calendar.getInstance().getTime());
    }

    public static void ShowMessage(String mensaje) {
        System.out.print((mensaje.charAt(0) + "").toUpperCase() + mensaje.substring(1, mensaje.length()));
    }



    public static String toMenu(String... ArrayOptions) {
        String menu = "";
        int caracteresFila = 0;
        ArrayOptions[0] = "|" + ArrayOptions[0].toUpperCase();

        for (int opciones = 0; opciones < ArrayOptions.length; opciones++) {
            if (opciones != 0) {
                ArrayOptions[opciones] = "|" + opciones + "-." + ArrayOptions[opciones] + " ";
            }
            caracteresFila = (caracteresFila + ArrayOptions[opciones].length() + Math.abs(caracteresFila - ArrayOptions[opciones].length())) / 2;

        }

        String raya = "";
        for (int o = 0; o < caracteresFila - 1; o++) {
            raya += "_";
        }

        menu += " " + raya + "%n";
        for (int o = 0; o < ArrayOptions.length; o++) {
            menu += ArrayOptions[o] + String.format("%" + ((caracteresFila + 3) - ArrayOptions[o].length()) + "s", "|%n");
            if (o == 0) {
                menu += "|" + raya + "|" + "%n";
            }
        }
        menu += "|" + raya + "|%n";
        
        return String.format(menu);
        
    }

    public static String ToTableMenu(int caracteres, String... opciones) {
        String menu ;
        int caracteresFila;
        TADCola serviCola = new TADCola();
        opciones[0] = "|" + opciones[0].toUpperCase();
        caracteresFila = caracteres + 3;
        String raya = "";
        String spacios = "";
        for (int o = 0; o < caracteresFila - 1; o++) {
            raya += "_";
            spacios += " ";
        }
        for (int a = 0; a < opciones.length; a++) {
            menu = opciones[a];
            if (a != 0) {
                menu = "|" + a + "-." + opciones[a] + " ";

            }
            if (menu.length() <= caracteres) {
                serviCola.acolar(menu);
            } else {
                int up = caracteres;
                serviCola.acolar(menu.substring(0, up));

                while (up <= menu.length()) {
                    serviCola.acolar("|" + menu.substring(up, (up + caracteres > menu.length()) ? menu.length() : up + caracteres));
                    up += caracteres;
                }

            }
            if (a < opciones.length - 1) {
                serviCola.acolar("|" + spacios);
            }

        }
        menu = "";

        menu += " " + raya + "%n";
        boolean pri = true;
        while (!serviCola.primero().equals("*")) {
            menu += serviCola.primero() + String.format("%" + ((caracteresFila + 3) - serviCola.decolar().length()) + "s", "|%n");
            if (pri) {
                menu += "|" + raya + "|" + "%n";
                pri = false;
            }
        }
        menu += "|" + raya + "|%n";

        return String.format(menu);
    }

    public static String getCharacteristics(boolean nu, String... opciones) {
        String mai = "";
        int caracteresFila = 0;
        opciones[0] = "|" + opciones[0].toUpperCase();

        for (int a = 0; a < opciones.length; a++) {
            if (a != 0) {
                opciones[a] = "|" + ((nu) ? a + "-." : "") + opciones[a] + " ";
            }
            caracteresFila = (caracteresFila + opciones[a].length() + Math.abs(caracteresFila - opciones[a].length())) / 2;

        }

        String raya = "";
        for (int o = 0; o < caracteresFila - 1; o++) {
            raya += "_";
        }

        mai += " " + raya + "%n";
        for (int o = 0; o < opciones.length; o++) {
            mai += opciones[o] + String.format("%" + ((caracteresFila + 3) - opciones[o].length()) + "s", "|%n");
            if (o == 0) {
                mai += "|" + raya + "|" + "%n";
            }
        }
        mai += "|" + raya + "|%n";

        return String.format(mai);
    }

    public static void pausa(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException es) {
            System.err.println("error se interrumpio la pausa");
        }
    }



}
