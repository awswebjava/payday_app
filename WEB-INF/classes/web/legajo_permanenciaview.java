package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajo_permanenciaview", "/web.legajo_permanenciaview"})
public final  class legajo_permanenciaview extends GXWebObjectStub
{
   public legajo_permanenciaview( )
   {
   }

   public legajo_permanenciaview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajo_permanenciaview.class ));
   }

   public legajo_permanenciaview( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajo_permanenciaview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajo_permanenciaview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "legajo_permanencia View";
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

