package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.banda_salarialview", "/web.banda_salarialview"})
public final  class banda_salarialview extends GXWebObjectStub
{
   public banda_salarialview( )
   {
   }

   public banda_salarialview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( banda_salarialview.class ));
   }

   public banda_salarialview( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new banda_salarialview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new banda_salarialview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "banda_salarial View";
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

