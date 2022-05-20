import groovy.xml.XmlSlurper
@Grab(group='org.ccil.cowan.tagsoup', module='tagsoup', version='1.2')
import org.ccil.cowan.tagsoup.Parser
//Hello world in Groovy
println("Hello world")

//Command line arguments
if(args.size() > 0){println(args[0])}

//Standard streams
//Input
def name = System.console().readLine("Write your name: ")
//Output
println("Hi, $name!")

//Environment variables
envVars = System.getenv("JAVA_HOME")
println envVars

//File IO
//File handler and creation
fileh = new File("/home/zolan/Desktop/filedemo.txt")
if(!fileh.exists()) {fileh.createNewFile()}
fileh.append("New line") //Write file

fileh.eachLine {line -> println(line)} //File Reading

fileh.write("Overwrite") //Another way of writing to a file

fileh.eachLine {line -> println(line)}

fileh.delete()

//Network IO
def tagsoupParser = new Parser()
def slurper = new XmlSlurper(tagsoupParser)
def htmlParser = slurper.parse("http://quotes.toscrape.com/")

htmlParser.'**'.findAll{ it.@class == "quote"}.each{
    println it
}
