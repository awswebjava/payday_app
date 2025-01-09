package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajo_deducciones", "/web.legajo_deducciones"})
public final  class legajo_deducciones extends GXWebObjectStub
{
   public legajo_deducciones( )
   {
   }

   public legajo_deducciones( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajo_deducciones.class ));
   }

   public legajo_deducciones( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajo_deducciones_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajo_deducciones_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "legajo_deducciones";
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

