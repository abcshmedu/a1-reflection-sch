# a1-reflection-schnitzel

Nico Dassler, Philipp Konopac

Die Tests scheitern unter Umständen, das liegt daran, dass die Reflection-Methode
getDeclaredMethods() alle Methoden in beliebiger Reihenfolge zurückgibt. Darauf hat der
Programierer keinen Einfluss. 
Siehe Java-DOkumentation: http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getDeclaredMethods--

Lösungsmöglichkeiten wären zB ein Scan des Source-Codes oder ein
weiteres Attribut in der Annotation, die die Reihenfolge bestimmt.