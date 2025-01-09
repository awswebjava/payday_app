package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.esquemahorasespecialesgeneral", "/web.esquemahorasespecialesgeneral"})
public final  class esquemahorasespecialesgeneral extends GXWebObjectStub
{
   public esquemahorasespecialesgeneral( )
   {
   }

   public esquemahorasespecialesgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( esquemahorasespecialesgeneral.class ));
   }

   public esquemahorasespecialesgeneral( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new esquemahorasespecialesgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new esquemahorasespecialesgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Esquema Horas Especiales General";
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

