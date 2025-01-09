package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.condicionafipview", "/web.condicionafipview"})
public final  class condicionafipview extends GXWebObjectStub
{
   public condicionafipview( )
   {
   }

   public condicionafipview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( condicionafipview.class ));
   }

   public condicionafipview( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new condicionafipview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new condicionafipview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Condicion AFIPView";
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

