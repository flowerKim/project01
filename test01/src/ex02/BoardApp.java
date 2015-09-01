package ex02;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class BoardApp {
  static Scanner scanner;
  
  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    String command = null;
    BoardDao boardDao=null;
    try {
      
      String resource = "ex02/mybais-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      boardDao = new BoardDao();
      boardDao.setSqlSessionFactory(sqlSessionFactory);
    } catch (Exception e) {
      e.printStackTrace();
    }

   do {
     System.out.println("명령 >");
     command = scanner.nextLine().toLowerCase();
     
     if(command.equals("list")) {
       List<Board> boards = boardDao.list();
       for(Board board : boards) {
         System.out.printf("%d, %s, %s, %d\n", 
             board.getNo(),
             board.getTitle(),
             board.getCreateDate(),
             board.getViewCount());
       }

     } else if(command.equals("insert")) {
       Board board = new Board();
       System.out.print("제목?");
       board.setTitle(scanner.nextLine());
       System.out.print("내용?");
       board.setContent(scanner.nextLine());
       System.out.print("암호");
       board.setPassword(scanner.nextLine());
       
       int count = boardDao.insert(board);
       if (count == 0) {
         System.out.println("입력실패!");
       } else {
         System.out.println("입력성공!");
       }
       
     } else if(command.equals("update")) {
       System.out.println("변경할 게시물 번호? ");
       int no = Integer.parseInt(scanner.nextLine());
       Board board = boardDao.get(no);
       
       System.out.printf("제목(%s) : ", board.getTitle());
       String newTitle = scanner.nextLine();
       if(newTitle.length() > 0 ) {
         board.setTitle(newTitle);
       }
       
       System.out.printf("내용(%s) : ", board.getContent());
       String newContent = scanner.nextLine();
       if(newContent.length() > 0 ) {
         board.setContent(newContent);
       }
       
       int count = boardDao.update(board);
       if(count==0) {
         System.out.println("변경 실패!");
       } else {
         System.out.println("변경 성공!");
       }
       
     } else if(command.equals("delete")) {
        System.out.println("삭제할 게시물 번호? ");
        int no = Integer.parseInt(scanner.nextLine());
        boardDao.delete(no);
        
     } else if(command.equals("quit")) {
       System.out.println("안녕히 가세요!");
       
     } else {
       System.out.println("해당 명령어 지원 안함");
     }
     
   } while(!command.equals("quit"));
   
   scanner.close();
  }
}
