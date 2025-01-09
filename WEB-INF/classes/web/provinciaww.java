package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.provinciaww", "/web.provinciaww"})
public final  class provinciaww extends GXWebObjectStub
{
   public provinciaww( )
   {
   }

   public provinciaww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( provinciaww.class ));
   }

   public provinciaww( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new provinciaww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new provinciaww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Provincia";
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

