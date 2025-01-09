package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.variable_exportvariable_valoreswc", "/web.variable_exportvariable_valoreswc"})
public final  class variable_exportvariable_valoreswc extends GXWebObjectStub
{
   public variable_exportvariable_valoreswc( )
   {
   }

   public variable_exportvariable_valoreswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( variable_exportvariable_valoreswc.class ));
   }

   public variable_exportvariable_valoreswc( int remoteHandle ,
                                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new variable_exportvariable_valoreswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new variable_exportvariable_valoreswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Variable_exportvariable_valores WC";
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

