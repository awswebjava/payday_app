package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.obligaciones", "/web.obligaciones"})
public final  class obligaciones extends GXWebObjectStub
{
   public obligaciones( )
   {
   }

   public obligaciones( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( obligaciones.class ));
   }

   public obligaciones( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new obligaciones_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new obligaciones_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Saldos de obligaciones";
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

