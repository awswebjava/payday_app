package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresabase_calculoww", "/web.empresabase_calculoww"})
public final  class empresabase_calculoww extends GXWebObjectStub
{
   public empresabase_calculoww( )
   {
   }

   public empresabase_calculoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresabase_calculoww.class ));
   }

   public empresabase_calculoww( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresabase_calculoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresabase_calculoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Base de cálculo";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

