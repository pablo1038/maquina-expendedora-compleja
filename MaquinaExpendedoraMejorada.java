public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Total de billetes vendidos desde la puesta en marcha de la maquina
    private int numeroBilletesVendidos;
    // Elegimos maquina con premios
    private boolean maquinaConPremio;
    // Numero m�ximo de billetes que la m�quina puede vender
    private int numeroMaximoBilletes;
    //Solo el billete indicado tendr� premio.
    private int billeteConPremio;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premio, int numeroM�ximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        numeroBilletesVendidos = 0;
        estacionDestino = destino;
        maquinaConPremio = premio;
        numeroMaximoBilletes = numeroM�ximoBilletes;
        billeteConPremio = 0;

    }

    
    public int vaciarDineroDeLaMaquina() { 
        int valorDinero = totalDineroAcumulado;
        if (balanceClienteActual != 0) {
            System.out.println("No se puede realizar la operaci�n, hay un proceso en curso");
            valorDinero = -1;
        }
        else {
            totalDineroAcumulado = 0; 
        } 
        return valorDinero;
    }

    public int getnumeroBilletesVendidos() {
        return numeroBilletesVendidos;
    }

    public void imprimeNumeroBilletesVendidos() {
        System.out.println("Se han imprimido" +  numeroBilletesVendidos);

    }    

    /** 
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroBilletesVendidos >= numeroMaximoBilletes) {
            System.out.println("No se puede introducir m�s dinero.");
          
        }      
        else {    
                if (cantidadIntroducida > 0) {
                    balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
                else {
                    System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }        
        }
    }

    public void imprimirBillete() {
        int cantidadDeDineroQueFalta;
        cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        double descuento = 0.10; 
            if (numeroBilletesVendidos >= numeroMaximoBilletes) {
                System.out.println("No es posible la impresi�n de m�s billetes");
        }
        else{
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         
    
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                // Numero M�ximo de Billetes 
                numeroBilletesVendidos = numeroBilletesVendidos + 1;
            }
            if (maquinaConPremio == true) {
                billeteConPremio = billeteConPremio + 1;
                if (billeteConPremio == 3) {
                    descuento = precioBillete * 0.10;
                    System.out.println("Le descontamos " + descuento + "�  por la compra del billete");
                    billeteConPremio = 0;
                    
            
                }
            }
            else {
                System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
    
            }            
        }
    }


    public void cambiarPrecioBillete() {
        int precioBillete;
        precioBillete = 17;
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual    ;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
