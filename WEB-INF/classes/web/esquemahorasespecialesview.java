package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.esquemahorasespecialesview", "/web.esquemahorasespecialesview"})
public final  class esquemahorasespecialesview extends GXWebObjectStub
{
   public esquemahorasespecialesview( )
   {
   }

   public esquemahorasespecialesview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( esquemahorasespecialesview.class ));
   }

   public esquemahorasespecialesview( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new esquemahorasespecialesview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new esquemahorasespecialesview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Esquema Horas Especiales View";
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

