package Lesson_1.frame_1.GreatingService;

class greatingService {

	public static void main (String args[]) {
			System.out.println ("Please, look to you Environment Variable, and set to change parametr PATH!");
	System.out.println ("Find, directory where you intsall JDK (Java development kit)");
	System.out.println ("Press key \"WIN\" - \"R\", in new window enter command \"cmd\", after that you can see black dialog window, whith command line");
	System.out.println ("in command line press \"cd+ space + full way, where you install JDK + \\bin\"");
  	System.out.println ("For example: \"cd c:\\Program Files\\Java\\JDK\\bin\\");
	System.out.println ("in command line write \"javac + space + name file with extension .java\", and press \"Enter\""); 
	System.out.println ("You java file compiled, new this file you can see new file with extension .class");
	System.out.println ("in command line write \"java + space + name file without extension + you name\", and press \"Enter\"");
	if (args.length>0) {
		System.out.println("Hello " + args[0]);
		System.out.println ("Congratulations! You java programm successfully done");
		}
	else {
		System.out.println("Please, read instruction again");

	}
		}
	}