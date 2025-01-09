package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.condiciones_conceptogeneral", "/web.condiciones_conceptogeneral"})
public final  class condiciones_conceptogeneral extends GXWebObjectStub
{
   public condiciones_conceptogeneral( )
   {
   }

   public condiciones_conceptogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( condiciones_conceptogeneral.class ));
   }

   public condiciones_conceptogeneral( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new condiciones_conceptogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new condiciones_conceptogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Condiciones_concepto General";
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

