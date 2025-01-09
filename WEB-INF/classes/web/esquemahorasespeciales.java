package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.esquemahorasespeciales", "/web.esquemahorasespeciales"})
public final  class esquemahorasespeciales extends GXWebObjectStub
{
   public esquemahorasespeciales( )
   {
   }

   public esquemahorasespeciales( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( esquemahorasespeciales.class ));
   }

   public esquemahorasespeciales( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new esquemahorasespeciales_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new esquemahorasespeciales_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Esquema Horas Especiales";
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

