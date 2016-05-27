package java8.time.ex;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Created by hernan on 26/05/2016.
 */
public class JTime {


    public static void main(String arg[]) {

        LocalTime horaActual = LocalTime.now();
        LocalDate fechaHoy = LocalDate.now();

        System.out.printf("%nHola, hoy es %s, " +
                        "justo a las %d horas, %d minutos, %d segundos y %d nanos.%n" +
                        "Vamos a probar la nueva clase LocalDate de Java 8.%n%n",
                fechaHoy, horaActual.getHour(), horaActual.getMinute(), horaActual.getSecond(), horaActual.getNano());

        DayOfWeek lunes = DayOfWeek.MONDAY;
        /*
        Este enum tiene algunos métodos interesantes que permite manipular días hacía adelante y hacia atrás:
         */
        System.out.printf("8 días será: %s%n", lunes.plus(8));
        System.out.printf("2 días antes fue: %s%n", lunes.minus(2));
        System.out.println("\n");

        /*
         Además, con el método getDisplayName() se puede acceder al texto que corresponde a la fecha,
         dependiendo del Locale actual, o el que definamos. Para mi país probé con esto:
         */
        //DayOfWeek lunes = DayOfWeek.MONDAY;
        Locale l = new Locale("es", "CO");
        System.out.println("TextStyle.FULL:" + lunes.getDisplayName(TextStyle.FULL, l));
        System.out.println("TextStyle.NARROW:" + lunes.getDisplayName(TextStyle.NARROW, l));
        System.out.println("TextStyle.SHORT:" + lunes.getDisplayName(TextStyle.SHORT, l));
        System.out.println("\n");

        /*
        Para los meses, existe el enum java.time.Month que básicamente hace lo mismo:
         */
        Locale l2 = new Locale("es"); //probamos con portugues
        Month mes = Month.MARCH;
        System.out.printf("Dos meses más y será: %s%n", mes.plus(2));
        System.out.printf("Hace 1 mes fué: %s%n", mes.minus(1));
        System.out.printf("Este mes tiene %s días %n ", mes.maxLength());
        System.out.printf("TextStyle.FULL:%s%n", mes.getDisplayName(TextStyle.FULL, l2));
        System.out.printf("TextStyle.NARROW:%s%n", mes.getDisplayName(TextStyle.NARROW, l2));
        System.out.println("\n");

        System.out.print("Las clases de fecha como el java.time.LocalDate manejan la fecha, pero, a diferencia del java.util.Date, es que es solo trabaja fecha, y no hora.");

        LocalDate fechaNacimiento = LocalDate.of(1979, Month.FEBRUARY, 21);
        System.out.printf("%nDia de la semana: %s.%n", fechaNacimiento.getDayOfWeek());
        DayOfWeek dia = fechaNacimiento.getDayOfWeek();
        System.out.printf("El día que nací fue el %s y fue un %s%n", fechaNacimiento, dia);

        System.out.printf("%n%s%n", "Para representar el mes de un año específico, usamos la clase java.time.YearMonth y también podemos obtener la cantidad de días de ese mes, sobre todo cuando jugamos con los bisiestos");
        YearMonth mesActual = YearMonth.now();
        System.out.printf("Este mes es %s y tiene %d días%n", mesActual, mesActual.lengthOfMonth());
        mesActual = YearMonth.of(2004, Month.FEBRUARY);
        System.out.printf("El mes %s tuvo %d días,%n", mesActual, mesActual.lengthOfMonth());
        mesActual = YearMonth.of(2002, Month.FEBRUARY);
        System.out.printf("el mes %s tuvo %d días,%n", mesActual, mesActual.lengthOfMonth());
        mesActual = YearMonth.of(2000, Month.FEBRUARY);
        System.out.printf("el mes %s tuvo %d días%n", mesActual, mesActual.lengthOfMonth());
        mesActual = YearMonth.of(1800, Month.FEBRUARY);
        System.out.printf("Pero el mes %s tuvo %d días ¿Sabías que no es considerado bisiesto?%n",
                mesActual, mesActual.lengthOfMonth());

        System.out.printf("%n%s%n", "La clase java.time.MonthDay representa a un día de un mes en particular, tal como decir que el año nuevo es el 1 de enero.");
        MonthDay dia2 = MonthDay.of(Month.FEBRUARY, 29);
        System.out.printf("El día %s %s es válido para el año 2010%n", dia2, dia2.isValidYear(2010) ? "SI" : "NO");
        //la respuesta será NO

        System.out.printf("%n%s%n", "Y la clase java.util.Year nos permite manipular y conocer sobre un año en específico, sin importar el día o mes.");
        Year año = Year.now();
        System.out.printf("Este año es %s y %s es bisiesto%n", año, año.isLeap() ? "sí" : "no");

        System.out.printf("%n--%s.%n", "Clase Hora");
        LocalTime justoAhora = LocalTime.now();
        System.out.printf("En este momento son las %d horas con %d minutos y %d segundos\n", justoAhora.getHour(),
                justoAhora.getMinute(), justoAhora.getSecond());
        LocalTime justoAhora2 = LocalTime.now();
        System.out.printf("En este momento son las %d horas con %d minutos y %d segundos\n", justoAhora2.getHour(),
                justoAhora2.getMinute(), justoAhora2.getSecond());


        System.out.printf("%n--%s.%n%s.%n", "Clase de hora/fecha", "La clase java.time.LocalDateTime manipula la fecha y la hora sin importar la zona horaria");
        LocalDateTime ahora = LocalDateTime.now();
        System.out.printf("La hora es: %s%n", ahora);
        LocalDateTime algunDia = LocalDateTime.of(1976, Month.MARCH, 27, 6, 10);
        System.out.printf("Yo nací el %s%n", algunDia);
        System.out.printf("Hace seis meses fue %s%n", LocalDateTime.now().minusMonths(6));

    }
}

