package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.condiciones_concepto", "/web.condiciones_concepto"})
public final  class condiciones_concepto extends GXWebObjectStub
{
   public condiciones_concepto( )
   {
   }

   public condiciones_concepto( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( condiciones_concepto.class ));
   }

   public condiciones_concepto( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new condiciones_concepto_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new condiciones_concepto_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Condiciones_concepto";
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

