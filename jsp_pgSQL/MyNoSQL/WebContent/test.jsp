<%@ page language="java" contentType="text/html;charset=utf-8" import="java.io.*" import="java.util.*" import="java.sql.*"%>
 
<html>
    <body>
        <%
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "123456";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql = "select * from table1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
        %>
        您的第一个字段内容为：
        <%=rs.getString(1)%>
        您的第二个字段内容为：
        <%=rs.getString(2)%>
        <%
            }
        %>
        
        <%
            out.print("数据库操作成功!!!");
        %>
        <%
            rs.close();
            stmt.close();
            conn.close();
        %>
    </body>
</html>