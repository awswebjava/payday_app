package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptosafipwizardinicio", "/web.conceptosafipwizardinicio"})
public final  class conceptosafipwizardinicio extends GXWebObjectStub
{
   public conceptosafipwizardinicio( )
   {
   }

   public conceptosafipwizardinicio( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptosafipwizardinicio.class ));
   }

   public conceptosafipwizardinicio( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptosafipwizardinicio_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptosafipwizardinicio_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Conceptos Afip Wizard Inicio";
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

