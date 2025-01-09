package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.puesto", "/web.puesto"})
public final  class puesto extends GXWebObjectStub
{
   public puesto( )
   {
   }

   public puesto( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( puesto.class ));
   }

   public puesto( int remoteHandle ,
                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new puesto_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new puesto_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Puesto";
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

