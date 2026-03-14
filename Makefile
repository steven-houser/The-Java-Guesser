guesser: Guesser.java
	javac -g Guesser.java

run: guesser
	java Guesser

clean:
	rm *.class

debug: guesser
	jdb Guesser
