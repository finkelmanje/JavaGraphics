package PixLab;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("src/PixLab/images/beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("src/PixLab/images/caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("src/PixLab/images/temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("src/PixLab/images/640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("src/PixLab/images/swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("src/PixLab/images/beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  public static void testNegate()
  {
    Picture beach = new Picture("src/PixLab/images/beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  
  public static void testGreyscale()
  {
    Picture water = new Picture("src/PixLab/images/water.jpg");
    water.explore();
    water.greyscale();
    water.explore();
  }
  
  public static void testFixUnderwater()
  {
    Picture water = new Picture("src/PixLab/images/water.jpg");
    water.explore();
    water.fixUnderwater();
    water.explore();
  }
  
   public static void testMirroVerticalRighttoLeft()
  {
    Picture beach = new Picture("src/PixLab/images/beach.jpg");
    beach.explore();
    beach.mirrorVerticalRightToLeft();
    beach.explore();
  }
   
   public static void testMirroHorizontal()
  {
    Picture beach = new Picture("src/PixLab/images/beach.jpg");
    beach.explore();
    beach.mirrorHorrizontal();
    beach.explore();
  }
   
   public static void testMirroHorizontalBotToTop()
  {
    Picture beach = new Picture("src/PixLab/images/beach.jpg");
    beach.explore();
    beach.mirrorHorrizontalBotToTop();
    beach.explore();
  }
   
    public static void testMirrorDiagonal()
  {
    Picture beach = new Picture("src/PixLab/images/beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
  }
    
    public static void testMirrorArms()
  {
    Picture snowman = new Picture("src/PixLab/images/snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }
    
    public static void testMirrorGull()
  {
    Picture gull = new Picture("src/PixLab/images/seagull.jpg");
    gull.explore();
    gull.mirrorGull();
    gull.explore();
  }
    
    public static void testCopy2()
  {
       //image = ImageIO.read(new File("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\JavaGraphics\\src\\Pixlab\\images\\seagull.jpg"));
   // Picture gull = new Picture(image);
    Picture gull = new Picture("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\JavaGraphics\\src\\PixLab\\images\\seagull.jpg");
    gull.explore();
    //gull.copy2();
    gull.explore();
  }
  
  
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
  //  testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
    //testKeepOnlyBlue();
    //testNegate();
     // testGreyscale();
     // testFixUnderwater();
    //  testMirroVerticalRighttoLeft();
      //testMirroHorizontal();
      //testMirroHorizontalBotToTop();
     // testMirrorDiagonal();
      testCopy2();
      
}
}