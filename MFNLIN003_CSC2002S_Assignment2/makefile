JAVAC=	/usr/bin/javac
SRCDIR=	src
BINDIR=	bin 
docdir=	doc

.SUFFIXES:	.java	.class

.java.class:
	$(JAVAC)	$<

default:
	$(JAVAC)	-d	(BINDIR)	$(SRCDIR)/*.java
clean:
	rm	$(BINDIR)/*.class
run1:
	java	-cp	bin Flow	"\SampleData\medsample_in.txt"
run2:
	java	-cp	bin Flow	"\SampleData\largesample_in.txt"
docs:
	javadoc	-d	$(docdir)	$(SRCDIR)/*.java

cleandocds:
	rm	-r	doc/*


