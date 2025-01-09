package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptosafipwizardconcepto1", "/web.conceptosafipwizardconcepto1"})
public final  class conceptosafipwizardconcepto1 extends GXWebObjectStub
{
   public conceptosafipwizardconcepto1( )
   {
   }

   public conceptosafipwizardconcepto1( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptosafipwizardconcepto1.class ));
   }

   public conceptosafipwizardconcepto1( int remoteHandle ,
                                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptosafipwizardconcepto1_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptosafipwizardconcepto1_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Conceptos Afip Wizard Concepto1";
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

