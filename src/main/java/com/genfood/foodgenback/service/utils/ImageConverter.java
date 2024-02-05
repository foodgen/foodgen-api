package com.genfood.foodgenback.service.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import javax.imageio.ImageIO;

public class ImageConverter {

  public static BufferedImage generatePreviewImage(String imageUrl, int width, int height)
      throws IOException {
    URL url = new URL(imageUrl);
    BufferedImage originalImage = ImageIO.read(url);

    // Resize the image to the specified width and height
    Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    BufferedImage previewImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    // Draw the resized image onto the preview image
    Graphics2D graphics = previewImage.createGraphics();
    graphics.drawImage(resizedImage, 0, 0, null);
    graphics.dispose();

    return previewImage;
  }

  public String BufferToBase64(BufferedImage image) throws IOException {
    ByteArrayOutputStream file = new ByteArrayOutputStream();
    ImageIO.write(image, "jpg", file);
    byte[] imageBytes = file.toByteArray();
    return Base64.getEncoder().encodeToString(imageBytes);
  }
}
