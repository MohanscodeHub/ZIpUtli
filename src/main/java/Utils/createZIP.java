package Utils;

import java.io.File;

public class createZIP {

    public static void main(String[] args) {

        listFilesInDirectory(new File("D:\\Govt id's"));

    }


    public static void listFilesInDirectory(File directory){

        File elements[] = directory.listFiles();

        for(File element:elements){

            if(element.isFile()){

                System.out.println(element);
            }

            else if(element.isDirectory()){

                listFilesInDirectory(element.getAbsoluteFile());
                System.out.println(element.getAbsoluteFile());

            }
        }


    }

}
