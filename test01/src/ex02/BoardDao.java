package ex02;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BoardDao {
  SqlSessionFactory sqlSessionFactory;
  
  
  public List<Board> list() {
    SqlSession sqlSession = null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      return sqlSession.selectList("ex02.list");
      
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      sqlSession.close();
    }
  }

  public int insert(Board board) {
   SqlSession sqlSession =null;
   try {
    sqlSession = sqlSessionFactory.openSession();
    int count = sqlSession.insert("ex02.insert", board);
    sqlSession.commit();
    return count;
    
  } catch (Exception e) {
     e.printStackTrace();
     return 0;
  } finally {
    sqlSession.close();
  }
  }

  public Board get(int no) {
    SqlSession  sqlSession=null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      return sqlSession.selectOne("ex02.get", no);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      sqlSession.close();
    }
  }

  public int update(Board board) {
    SqlSession sqlSession=null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      int count = sqlSession.update("ex02.update", board);
      sqlSession.commit();
      return count;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    } finally {
      sqlSession.close();
    }
    
  }

  public int delete(int no) {
    SqlSession sqlSession=null;
    try {
      sqlSession = sqlSessionFactory.openSession();
      int count = sqlSession.delete("ex02.delete", no);
      sqlSession.commit();
      return count;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    } finally {
      sqlSession.close();
    }
  }

  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory2) {
   this.sqlSessionFactory = sqlSessionFactory;
    
  }

}
