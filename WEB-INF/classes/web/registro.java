package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.registro", "/web.registro"})
public final  class registro extends GXWebObjectStub
{
   public registro( )
   {
   }

   public registro( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( registro.class ));
   }

   public registro( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new registro_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new registro_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Registro";
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

