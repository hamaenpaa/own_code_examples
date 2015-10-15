vbjc ConverterHome.java
java2iiop -compile ConverterHome
vbjc *.java
jar cMf Converter.jar META-INF *.class
vbj com.inprise.ejb.util.Verify Converter.jar
