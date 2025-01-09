package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.zonaww", "/web.zonaww"})
public final  class zonaww extends GXWebObjectStub
{
   public zonaww( )
   {
   }

   public zonaww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( zonaww.class ));
   }

   public zonaww( int remoteHandle ,
                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new zonaww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new zonaww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Zona";
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

