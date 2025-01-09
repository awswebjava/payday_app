package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptosafipwizardpaso2dummy", "/web.conceptosafipwizardpaso2dummy"})
public final  class conceptosafipwizardpaso2dummy extends GXWebObjectStub
{
   public conceptosafipwizardpaso2dummy( )
   {
   }

   public conceptosafipwizardpaso2dummy( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptosafipwizardpaso2dummy.class ));
   }

   public conceptosafipwizardpaso2dummy( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptosafipwizardpaso2dummy_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptosafipwizardpaso2dummy_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Conceptos Afip Wizardpaso2 Dummy";
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

