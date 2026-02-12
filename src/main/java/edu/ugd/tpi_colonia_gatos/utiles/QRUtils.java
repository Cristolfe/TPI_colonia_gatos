/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.utiles;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;

public class QRUtils {

    public static String generarQRBase64(String texto) throws WriterException, IOException {
        int width = 200;
        int height = 200;
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, width, height);

        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(qrImage, "png", baos);
        byte[] bytes = baos.toByteArray();

        return Base64.getEncoder().encodeToString(bytes);
    }
}
