package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.variablevaloresww", "/web.variablevaloresww"})
public final  class variablevaloresww extends GXWebObjectStub
{
   public variablevaloresww( )
   {
   }

   public variablevaloresww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( variablevaloresww.class ));
   }

   public variablevaloresww( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new variablevaloresww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new variablevaloresww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Variable Valores";
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

