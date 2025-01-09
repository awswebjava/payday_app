package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptosafipwizard", "/web.conceptosafipwizard"})
public final  class conceptosafipwizard extends GXWebObjectStub
{
   public conceptosafipwizard( )
   {
   }

   public conceptosafipwizard( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptosafipwizard.class ));
   }

   public conceptosafipwizard( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptosafipwizard_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptosafipwizard_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Conceptos Afip Wizard";
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

