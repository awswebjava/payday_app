package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajo_permanencia", "/web.legajo_permanencia"})
public final  class legajo_permanencia extends GXWebObjectStub
{
   public legajo_permanencia( )
   {
   }

   public legajo_permanencia( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajo_permanencia.class ));
   }

   public legajo_permanencia( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajo_permanencia_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajo_permanencia_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "legajo_permanencia";
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

