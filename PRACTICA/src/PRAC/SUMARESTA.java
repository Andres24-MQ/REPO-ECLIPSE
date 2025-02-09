package PRAC;
import java.util.Iterator;
import java.util.Scanner;

public class SUMARESTA {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido: ");
		int num1, num2;
		String nombre;
		double radio;
		int n1;
		//n1= sc.nextInt();h
		double iva = 0.21;
		double precio;
		double pprod;
		//pprod= sc.nextDouble();
		int n=0;
//radio= sc.nextDouble();
//num1= sc.nextInt();
//num2= sc.nextInt();
//nombre= sc.next();

/*System.out.println("la suma es: "+ (num1+num2));
System.out.println("la resta es: "+(num1-num2));
System.out.println("la multiplicacion es: "+num1*num2);
System.out.println("la division es:"+ (num1/num2));
	
if (num1>=num2){ //comprueba si es igual y mayor
    if(num1==num2){
        System.out.println("Los numeros "+num1+" y "+num2+" son iguales");
    }else{
        System.out.println("El número "+num1+" es mayor que el número "+num2);
    }
}else{
    System.out.println("El número "+num2+" es mayor que el número "+num1);
}*/

//System.out.println("bienvenido "+nombre);

//double area=Math.PI*Math.pow(radio, 2);
//System.out.println("el area del circulo es: "+ area);

/*if (n1%2==0){
    System.out.println("El numero "+n1+" es divisible entre 2");
}else{
    System.out.println("El numero "+n1+" no es divisible entre 2");
}*/
		
		/*System.out.println("PRECIO DEL PRODUCTO: "+pprod);
		System.out.println("IVA: "+pprod*iva);
		precio= pprod+(pprod*iva);
System.out.println("precio del producto: "+ precio);*/

/*do {
	n++;
	System.out.println(n);
} while (n<3); //la condicion (n<3) tiene que ser falsa para que se salga
		System.out.println("limite alcanzado");
		
	for (int i = 0; i <=100; i++) {
		System.out.println(i);
	}*/	
		  /* int num=1;
		   //esto mmuestra los numeros divisibles entre 5 del 1 al 100
	        //Definimos el bucle, incluye el 100
	        while (num<=100){
	            if (num%5==0){
	                System.out.println(num);
	            }
	            //Incrementamos num
	            num++;
	        }*/		
		System.out.println("Cuantas ventas hubo? ");
		int NV;
		NV= sc.nextInt();
		int TV = 0;
		int MV;
		for (int i = 1; i <= NV; i++) {
			System.out.println("Monto de la venta n: "+i);
			MV=sc.nextInt();
			TV=TV+MV;
			
		}
		System.out.println("El total es: "+TV);
		
		
		/*int nn;
do {
	System.out.println("Introduce un num: ");
	nn=sc.nextInt();	
} while (nn<=0); //se sale del do hasta que la condicion sea falsa  (nn<=0), en este caso si yo introduzco un num negativo, comprueba que es negrativo, entonces lo vuelve a hacer 
//el proceso mientras la condicion sea verdadera, y como le puse que sea negativo y nosotros queremos uno positivo, pues lo vuelve a pedir. hazlo, mientras la condicion sea verdadera.
		System.out.println(" "+nn);*/
		
	/*System.out.println("Introduce la contraseña: ");	
		String contraseña= "traka";
	int ni=3;
	boolean acierto=false;
	for (int i = 1; i <= ni || acierto; i++) { // || es como un O y el && es un y
		System.out.println("intento num "+i+":");
		String contra= sc.next();
		
		if (contra.equals(contraseña)) {
			System.out.println("ACCESO PERMITIDO");
		}	
	}*/
	
		System.out.println("introduce un dia de la semana: ");
		
	String dia =sc.next();
	switch (dia) {
	case "lunes":
		System.out.println("dia laboral");
		break;
	case "martes":
		System.out.println("dia laboral");
		break;
	case "miercoles":
		System.out.println("dia laboral");
		break;
	case "jueves":
		System.out.println("dia laboral");
		break;
	case "viernes":
		System.out.println("dia laboral");
		break;
	case "sabado":
		System.out.println("dia festivo");
		break;
	case "domingo":
			System.out.println("dia festivo");
			break;
	default:
		System.out.println("introduce un dia de la semana");
		break;
	}
		/*System.out.println("NUMEROS ALEATORIOS ENTRE UN RANGO");
		int numm1, numm2;
		System.out.println("Numero 1:");
		numm1 = sc.nextInt();
		System.out.println("Numero 2:");
		numm2 = sc.nextInt();
		
		int numAleatorio=(int)Math.ceil((Math.random()*(numm1-numm2))+numm2);
        System.out.println("Numero seleccionado: "+numAleatorio);
		
        double numero = 5.3;
        double resultado = Math.floor(numero);
        System.out.println("Redondeando hacia arriba el número " + numero + ": " + resultado);
    
		
        double aleatorio = Math.random();
        System.out.println("Número aleatorio entre 0 y 1: " + aleatorio);
        */
        
        
		//de grados a radianes
       /* double anguloGrados = sc.nextDouble();
        double anguloRadianes = Math.toRadians(anguloGrados);
        System.out.println(anguloGrados + " grados equivalen a: " + anguloRadianes + " radianes");
		*/
        
       
	/*	//numero elevado a una potencia
        double nn1=sc.nextDouble();
        double nn2=sc.nextDouble();
        double rels= Math.pow(nn1, nn2);
        System.out.println(rels);
        double bb=2.1;
		double suma=rels+bb;
        System.out.println(suma);
*/
		
		/*este programa pide un num positivo y comprueba que sea positivo, ademas cuenta cuantas cifras tiene ese numero, con un for que se repite las veces que es el numero entre 10, hasta 
		que el numero sea un decimal porque es int y ahi se para, si le pones un double salen mas cifras, por eso si pones un 120, divide entre 10 y da 12, y contador +1, luego 12 entre 10 da 1.2, 
		y contador ya va en +2, luego 1.2 entre 10 es 0.12 y contador lleva 3, pero aqui se detiene ya porque 0.12 no se puede dividir entre 10 porque ya no da un int.*/
      /*  int n7;
		do {
			System.out.println("introduce un numero positivo: ");
			n7= sc.nextInt();
		} while (n7<0);
		System.out.println("numero positivo");
		
		 int contador=0;
		 for (int i=n7;i>0;i/=10){
	            contador++;
	        }
		 if (contador==1){
	            System.out.println("El numero "+n7+ " tiene "+contador+" cifra");
	        }else{
	            System.out.println("El numero "+n7+ " tiene "+contador+" cifras");
	        }
        */
		
        System.out.println("Introduce un numero");
        int numero = sc.nextInt();
 
        //Un numero negativo, el 0 y el 1, son directamente no primos.
        if (numero <= 1) {
            System.out.println("El numero " + numero + " no es primo");
        } else {
 
            //Hacemos un casting para que nos devuelva un numero entero
            int raiz = (int) Math.sqrt(numero);
            int contador = 0;
 
            //Contamos el numero de divisibles
            for (int i = raiz; i > 1; i--) {
                if (numero % i == 0) {
                    contador++;
                }
            }
 
            /*Segun el numero de divisibles, sabemos si es primo o no
                 * Si es primo el contador sera 0
             */
            //Mensaje de traza
            System.out.println(">>" + contador);
 
            if (contador < 1) {
                System.out.println("El numero " + numero + " es primo");
            } else {
                System.out.println("El numero " + numero + " no es primo");
            }
 
        }
		
		 
		 
		 
	}

}
