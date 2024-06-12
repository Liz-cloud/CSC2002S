JAVAC=	/usr/bin/javac
SRCDIR=	src
BINDIR=	bin 
docdir=	./docs

.SUFFIXES:	.java	.class

.java.class:
	$(JAVAC)	$<

default:
	$(JAVAC)	-d	(BINDIR)	$(SRCDIR)/*.java
clean:
	rm	-f	$(BINDIR)/*.class
run1:
	java	-cp	bin Sequential
run2:
	java	-cp	bin Sequential	"\src\Data\large_in.txt"
run3:
	java	-cp	bin	Parallel
run4:
	java	-cp	bin	Parallel	"\src\Data\large_in"
docs:
	javadoc	-d	$(docdir)	$(SRCDIR)


