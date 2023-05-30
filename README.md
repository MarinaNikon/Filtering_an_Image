# **Filtering_an_Image**

#### Author: Marina Nikonchuk

#### Final Project for the Module "Object Oriented Software Development" of the H.Dip in Computer Science in Software Development - GMIT

### Project Description
With this program 'Filtering an Image with a Convolution Kernel', the user can process images using various filters. To do this, the user should select an image, select the filter he wants to use for processing the image, and save the resulting image with a different title.

16 filters are used to process photos (listed below).
+	1 - Identity
+	2 - Edge Detection_1
+	3 - Edge Detection_2
+	4 - Laplacian
+	5 - Sharpen
+	6 - Vertical Lines
+	7 - Horizontal Lines
+	8 - Diagonal 45 Lines
+	9 - Box Blur
+	10 - Sobel Horizontal
+	11 - Sobel Vertical
+	12 - Emboss
+	13 - Scharr Horizontal
+	14 - Scharr Vertical
+	15 - Gaussian Blur
+	16 - Execessive Edges

  
  After runing the programm the user sees 5 options:  
   
1. Enter Image Name (Ask user to specify the file to process). 
2. List of Filters (List the set of filters available in the class Kernel.java)
3. Select a Filter (Ask user to specify the filter to process). 
4. Quit (Terminate)
5. Select Option [1-4]  

By choosing any options, the user can perform different actions.


### Running project
The project is contained in the src folder. Compiled by entering the src directory and entering the commands:-  
$javac ie/gmit/dip/*.java

The compiled program is called with:-  
$java ie.gmit.dip.Runner


