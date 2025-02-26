//C�digo para informar a quantidade de pixels verdes presentes da imagem Syngenta.bmp

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class ContaPixels {
	public static void main(String[] args) {
		new ContaPixels().carregar();
	}

	public void carregar() {
		BufferedImage imagem = null;

		try {
			imagem = ImageIO.read(getClass().getResourceAsStream("img/Syngenta.bmp"));
			// Carrega a imagem para o c�digo.

			int w = imagem.getWidth();
			int h = imagem.getHeight();
			int contaVerde = 0;

			System.out.println();

			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					
					//Pegando o RGB do Pixel de coordenada x,y e alocando em uma vari�vel.
					int pixel = imagem.getRGB(x, y); 
					
					//Criando objeto do tipo Color a partir do valor RGB alocado em pixel.
					Color cor = new Color(pixel, true); 
					
					//Inserindo valores RGB de color em vari�veis, separando por cor.
					int vermelho = cor.getRed();
					int verde = cor.getGreen();
					int azul = cor.getBlue();

					if (verde > vermelho && verde > azul) {
						contaVerde++;
					}
				}
			}
			System.out.printf("H� %d pixels verdes na imagem", contaVerde);

		}catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
