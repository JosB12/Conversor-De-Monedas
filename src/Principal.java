import java.lang.ref.Cleaner;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarApi consulta = new ConsultarApi();
        div();
        System.out.println("Bienvenido a tu conversor de confianza");
        div();

        byte opc = 0;
        do {
            menu();
            opc = lectura.nextByte();
            if(opc>=1 && opc <= 6){
                conversion(opc,consulta,lectura);
            } else if (opc == 7) {
                System.out.println("Saliendo del programa...");
            }else {
                System.out.println("Opcion no valida, intente nuevamente.");
            }

        }while(opc != 7);
    }

    public static void div(){
        System.out.println("**********************************");
    }
    public static void menu(){
        System.out.println("\n1) Dolar =>> Peso dominicano");
        System.out.println("2) Peso dominicano =>> Dolar");
        System.out.println("3) Dolar ==> Peso mexicano");
        System.out.println("4) Peso mexicano ==> Dolar");
        System.out.println("5) Dola ==> Real brasileño");
        System.out.println("6) Real brasileño ==> Dolar");
        System.out.println("7) Salir");
        System.out.println("Elije la opcion que deseas: ");
        div();
    }

    public static void conversion(byte opc, ConsultarApi consulta, Scanner lectura){
        System.out.print("Ingrese el monto a convertir: ");

        var monto = lectura.nextDouble();

        String moneda ="";
        String convertir ="";

        switch (opc){
            case 1:
                moneda = "USD";
                convertir = "DOP";
                break;
            case 2:
                moneda = "DOP";
                convertir = "USD";
                break;
            case 3:
                moneda = "USD";
                convertir = "MXN";
                break;
            case 4:
                moneda = "MXN";
                convertir = "USD";
                break;
            case 5:
                moneda = "USD";
                convertir = "BRL";
                break;
            case 6:
                moneda = "BRL";
                convertir = "USD";
                break;
        }
        try{
            Monedas monedas6 = consulta.buscarModedas(moneda,convertir,monto);
            System.out.println("El valor " + monto + " " +monedas6.toString());
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finazilando aplicacion");
        }
    }
}
