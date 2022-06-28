package ie.gmit.dip;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

import javax.imageio.ImageIO;

public class Runner {
	

    public static double[][] kernel = Kernel.HORIZONTAL_LINES;

    public static void main(String[] args) {

        System.out.println(ConsoleColour.YELLOW);
       
        boolean loop = true;

        do {
            System.out.println(ConsoleColour.BLUE_BRIGHT);
            System.out.println("***************************************************");
            System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
            System.out.println("*                                                 *");
            System.out.println("*           Image Filtering System V0.1           *");
            System.out.println("*     H.Dip in Science (Software Development)     *");
            System.out.println("*                                                 *");
            System.out.println("***************************************************");
            System.out.println("1) Enter Image Name"); //Ask user to specify the file to process. 
            System.out.println("2) List of Filters"); //List the set of filters available in the class Kernel.java
            System.out.println("3) Select A Filter"); //Ask user to specify the filter to process. 
            System.out.println("4) Quit"); //Terminate
            System.out.println("\nSelect Option [1-4]>");
            System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
            Scanner scanner = new Scanner(System.in);
            String num = scanner.nextLine().trim();
            
            switch (num) {
                case "1": //Ask user to specify the file to process.
                    try {
                        System.out.println(ConsoleColour.BLUE);
                        System.out.println("Enter Image Name");
                        System.out.println(ConsoleColour.RESET);
                        String fileName = getInput().trim();	//Get the file name, append the extension.
                        System.out.println(ConsoleColour.BLUE);
                        String path = fileName;
                        File file = new File(path);
                        if(file.exists())
                        {
                        	// Read in an image and convert to a BufferedImage
                            BufferedImage inputImage = ImageIO.read(new File(path));
                            //apply kernel filters 
                            applyFilter(inputImage, kernel);
                            break;
                        }
                        else {
                        	// In the case of error in printed image name 
                            System.out.println(ConsoleColour.RED);
                            System.out.println("No Such File Found!");
                            System.out.println("Please try again.");
                            break;
                            
                        }

                    } catch (NoSuchFileException ex){
                        System.out.println(ex.getMessage());
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage()); 
                        scanner.close();
                    }

                case "2": //List the set of filters available in the class Kernel.java
                    System.out.println(ConsoleColour.YELLOW);
                    System.out.println("List of kernels:");
                    System.out.println("1 - IDENTITY");
                    System.out.println("2 - EDGE DETECTION_1");
                    System.out.println("3 - EDGE DETECTION_2");
                    System.out.println("4 - LAPLACIAN");
                    System.out.println("5 - SHARPEN");
                    System.out.println("6 - VERTICAL LINES");
                    System.out.println("7 - HORIZONTAL LINES");
                    System.out.println("8 - DIAGOANL 45 LINES");
                    System.out.println("9 - BOX BLUR");
                    System.out.println("10 - SOBEL HORIZONTAL");
                    System.out.println("11 - SOBEL VERTICAL");
                    System.out.println("12 - EMBOSS");
                    System.out.println("13 - SCHARR HORIZONTAL");
                    System.out.println("14 - SCHARR VERTICAL");
                    System.out.println("15 - GAUSSIAN BLUR");
                    System.out.println("16 - EXECESSIVE EDGES");
                    break;

                case "3": //Ask user to specify the filter to process. 

                    System.out.println("Select a filter");
                    int filterNum = Integer.parseInt(getInput());
                    if (filterNum <= 16 && filterNum >= 1) {
                        chooseKernel(filterNum);
                        break;
                    } 
                    else {
                        System.out.println("Incorrect number of filter.");
                        System.out.println("The number of filters ranges from 1 to 16.");
                        break;
                    }

                case "4": //Terminate
                    System.out.println("Goodbye...");
                    loop = false;
                    break;
                default:
                    System.out.println(ConsoleColour.RED);
                    System.out.println("Incorrect option.");
                    System.out.println("Please, repeat.");
            }
        } while (loop);
    }


    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim(); 
        return s;
        
    } 

    private static void chooseKernel(int number) { //Shows which filter the user has selected
        switch (number) {
            case 1:
                kernel = Kernel.IDENTITY;
                System.out.println( "IDENTITY" );
                break;
            case 2:
                kernel = Kernel.EDGE_DETECTION_1;
                System.out.println( "EDGE DETECTION_1" );
                break;
            case 3:
                kernel = Kernel.EDGE_DETECTION_2;
                System.out.println( "EDGE DETECTION_2" );
                break;
            case 4:
                kernel = Kernel.LAPLACIAN;
                System.out.println( "LAPLACIAN" );
                break;
            case 5:
                kernel = Kernel.SHARPEN;
                System.out.println( "SHARPEN" );
                break;
            case 6:
                kernel = Kernel.VERTICAL_LINES;
                System.out.println( "VERTICAL LINES" );
                break;
            case 7:
                kernel = Kernel.HORIZONTAL_LINES;
                System.out.println( "HORIZONTAL LINES" );
                break;
            case 8:
                kernel = Kernel.DIAGONAL_45_LINES;
                System.out.println( "DIAGOANL 45 LINES" );
                break;
            case 9:
                kernel = Kernel.BOX_BLUR;
                System.out.println( "BOX BLUR" );
                break;
            case 10:
                kernel = Kernel.SOBEL_HORIZONTAL;
                System.out.println( "SOBEL HORIZONTAL" );
                break;
            case 11:
                kernel = Kernel.SOBEL_VERTICAL;
                System.out.println( "SOBEL VERTICAL" );
                break;
            case 12:
                kernel = Kernel.EMBOSS;
                System.out.println( "EMBOSS" );
                break;
            case 13:
                kernel = Kernel.SCHARR_HORIZONTAL;
                System.out.println( "SCHARR HORIZONTAL" );
                break;
            case 14:
                kernel = Kernel.SCHARR_VERTICAL;
                System.out.println( "SCHARR VERTICAL" );
                break;
            case 15:
                kernel = Kernel.GAUSSIAN_BLUR;
                System.out.println( "GAUSSIAN BLUR" );
                break;
            case 16:
                kernel = Kernel.EXECESSIVE_EDGES;
                System.out.println( "EXECESSIVE EDGES" );
                break;
        }
    }

    private static void applyFilter(BufferedImage input, double[][] kernel)  {
        try {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Save file as:");
            String outputFileName = sc1.nextLine().trim();
            //Create buffered image object outputImage 
            BufferedImage outputImage = new BufferedImage(input.getWidth(), input.getHeight(), input.getType());
            
            
            
          //Image dimension 
            int WIDTH = input.getWidth();
            int HEIGHT = input.getHeight();

          // Loop over the 2D image to process each pixel 
            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {


                    float red = 0; //red
                    float green = 0; //green
                    float blue = 0; //blue

                    // apply filter for kernel
                    for (int i = 0; i < kernel.length; i++) {
                        for (int j = 0; j < kernel.length; j++) {

                        	
                        	// Multiply X and Y coordinates of the pixel with corresponding kernel element 
    						// In case of edges of image the '% WIDTH' wraps the image and the pixel from opposite edge is used 
                            int imageX = (x - (kernel.length - 1) / 2 + i + WIDTH) % WIDTH;
                            int imageY = (y - (kernel.length - 1) / 2 + j + HEIGHT) % HEIGHT;

                            int pixel = input.getRGB(imageX, imageY);
                            int R = (pixel >> 16) & 0xff; // Red value
                            int G = (pixel >> 8) & 0xff; // Green value
                            int B = (pixel) & 0xff; // Blue value

                            //The RGB is multiplied with current kernel element and added on to the variables red, blue and green 
                            red += (R * kernel[i][j]);
                            green += (G * kernel[i][j]);
                            blue += (B * kernel[i][j]);
                        }
                    }
                    
                    // Truncate values smaller than zero and larger than 255 
                    int outR = Math.min(Math.max((int) (red), 0), 255);
                    int outG = Math.min(Math.max((int) (green), 0), 255);
                    int outB = Math.min(Math.max((int) (blue), 0), 255);
                   // Pixel is written to output image 
                    outputImage.setRGB(x, y, new Color(outR, outG, outB).getRGB());
                }
            }
            

          // Save the result as a new file 
            ImageIO.write(outputImage, "png", new File(outputFileName));
            
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
    



}