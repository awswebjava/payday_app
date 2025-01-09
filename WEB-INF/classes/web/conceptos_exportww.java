package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptos_exportww", "/web.conceptos_exportww"})
public final  class conceptos_exportww extends GXWebObjectStub
{
   public conceptos_exportww( )
   {
   }

   public conceptos_exportww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptos_exportww.class ));
   }

   public conceptos_exportww( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptos_exportww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptos_exportww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Conceptos_export";
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

