package Uppgift1;

import java.io.*;

public class uppgift1 {
    /**
     *Metoden som filtrerar en textfil och tar bort alla symboler som inte är en bokstav, ny rad eller mellanslag.
     * Hittar vi en symbol som ska tas bort så byter vi ut den mot mellanslag.
     * Vi skriver över all data till en ny textfil och behåller den gamla.
     */
    public static void filter(FileWriter newFile, FileReader file) throws IOException {
      int value;
      char c;
      while((value = file.read()) != -1){
          c = (char) value;
             if(Character.isLetter(c) || Character.isSpaceChar(c) || Character.isWhitespace(c))
                 newFile.write(c);
             else
                 newFile.write(' ');
    }
}
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("/Users/fredrikpettersson/IdeaProjects/Laboration3/src/textfile.txt");
        FileWriter newFile = new FileWriter("/Users/fredrikpettersson/IdeaProjects/Laboration3/src/newtextfile.txt");
        filter(newFile, file);

    }
}
