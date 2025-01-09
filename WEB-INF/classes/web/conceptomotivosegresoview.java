package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptomotivosegresoview", "/web.conceptomotivosegresoview"})
public final  class conceptomotivosegresoview extends GXWebObjectStub
{
   public conceptomotivosegresoview( )
   {
   }

   public conceptomotivosegresoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptomotivosegresoview.class ));
   }

   public conceptomotivosegresoview( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptomotivosegresoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptomotivosegresoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Concepto Motivos Egreso View";
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

