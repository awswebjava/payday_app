package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.banda_salarialww", "/web.banda_salarialww"})
public final  class banda_salarialww extends GXWebObjectStub
{
   public banda_salarialww( )
   {
   }

   public banda_salarialww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( banda_salarialww.class ));
   }

   public banda_salarialww( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new banda_salarialww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new banda_salarialww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " banda_salarial";
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

