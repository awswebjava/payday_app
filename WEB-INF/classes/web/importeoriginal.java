package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importeoriginal", "/web.importeoriginal"})
public final  class importeoriginal extends GXWebObjectStub
{
   public importeoriginal( )
   {
   }

   public importeoriginal( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importeoriginal.class ));
   }

   public importeoriginal( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importeoriginal_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importeoriginal_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Importe Original";
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

