package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.variable_valoresview", "/web.variable_valoresview"})
public final  class variable_valoresview extends GXWebObjectStub
{
   public variable_valoresview( )
   {
   }

   public variable_valoresview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( variable_valoresview.class ));
   }

   public variable_valoresview( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new variable_valoresview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new variable_valoresview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "variable_valores View";
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

