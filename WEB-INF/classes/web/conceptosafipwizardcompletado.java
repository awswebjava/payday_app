package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptosafipwizardcompletado", "/web.conceptosafipwizardcompletado"})
public final  class conceptosafipwizardcompletado extends GXWebObjectStub
{
   public conceptosafipwizardcompletado( )
   {
   }

   public conceptosafipwizardcompletado( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptosafipwizardcompletado.class ));
   }

   public conceptosafipwizardcompletado( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptosafipwizardcompletado_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptosafipwizardcompletado_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Conceptos Afip Wizard Completado";
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

