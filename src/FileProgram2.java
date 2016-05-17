import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileProgram2 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("res/images/photo.bmp");
		FileOutputStream fos = new FileOutputStream("res/images/photo-copy.bmp");
		
		// 사진size 출력
		fis.read();
		fis.read();
		
		byte[] buf = new byte[4];
		
		buf[0] = (byte)fis.read();
		buf[1] = (byte)fis.read();
		buf[2] = (byte)fis.read();
		buf[3] = (byte)fis.read();
		
		//[0][1][2][3] -> int totalSize;
		int totalSize = ((int)buf[3])<<24 | ((int)buf[2])<<16 | ((int)buf[1])<<8 | ((int)buf[0])<<0; 
		
		//buf[0]부터 buf[3]까지를 합해서 totalSize에 저장
				//shift 연산자를 사용해 비트 자리를 옮기고 | 연산자를 이용해 비트를 합해줌
				// big endian : CPU가 오른쪽부터 비트를 채워나간다. (표준방식)
				// little endian : 왼쪽부터
		
		System.out.println(totalSize);
				
		//Width (너비) 출력
		/*for(int i=0; i<18; i++)
			fis.read();
		
		byte[] buf = new byte[4];
		
		buf[0] = (byte)fis.read();
		buf[1] = (byte)fis.read();
		buf[2] = (byte)fis.read();
		buf[3] = (byte)fis.read();
		
		int Width = ((int)buf[3])<<24 | ((int)buf[2])<<16 | ((int)buf[1])<<8 | ((int)buf[0])<<0;
		
		System.out.println(Width);*/
		
		//fos.write(fis.read()); //코딩은 편하지만 비효율적(하나씩 옮긴다) -> 배열을 사용하자
		
		
		/* 
		 while(fis.read() != -1)
		 	fos.write(fis.read());  // 매우 큰 실수 - 두 번읽어서 파일 사이즈가 반으로 나뉨 - 짝수번째 읽어온 값은 -1과 비교, 홀수 번째만 출력하는 결과발생
		 */
		
		// 바이트 단위로 파일을 복사하는 가장 효율적인 방법(경력자에게 가독성이 더 좋을 수 있음) :
		/*int n;
		
		while((n = fis.read()) != -1)
			fos.write(n);*/
		
		//바이트 단위가 너무 작아서 시간이 오래걸림
		//1KB씩 읽어오도록 하는 방법
		//CPU>메모리>하드디스크 : 속도
		
		/*byte[] buf = new byte[1024]; //1024 바이트씩 읽어오도록 배열 준비 ( 위의 방법보다 속도가 1024배)
		
		int size;
		
		while((size=fis.read(buf)) != -1)
			fos.write(buf, 0, size);*/
		
		// read 함수에는 읽어와서 바로 넣어주는 (여기서는 buf에) 역할도 있다. 
		// size = 한 번에 읽어오는 크기 (마지막으로 읽어올 때에는 남은 값이 1024바이트보다 작을 확률이 크다)
		// 마지막에 3바이트가 남아도 남은 공간까지 합해서 1024바이트를 가져온다. 남은 공간의 낭비와 쓰레기값이 출력되는 걸 막아야한다. 
		// 그래서 write 함수는 읽어올 값의 범위를 지정해줄 수 있다. 이 문제에서는 0부터 size까지 값을 출력한다.
		
		/* 흔한 방법	(초보자에게 코드가독성이 좋음)
		int n;
		
		while(true)
		{
			n = fis.read();
			
			if(n==-1)
				break;
			else
				fos.write(n);
		}
		*/
		fos.close();
		fis.close();
	}
}
