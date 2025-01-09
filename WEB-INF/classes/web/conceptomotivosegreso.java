package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptomotivosegreso", "/web.conceptomotivosegreso"})
public final  class conceptomotivosegreso extends GXWebObjectStub
{
   public conceptomotivosegreso( )
   {
   }

   public conceptomotivosegreso( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptomotivosegreso.class ));
   }

   public conceptomotivosegreso( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptomotivosegreso_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptomotivosegreso_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Concepto Motivos Egreso";
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

