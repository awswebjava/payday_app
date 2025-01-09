package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajolicenciasgeneral", "/web.legajolicenciasgeneral"})
public final  class legajolicenciasgeneral extends GXWebObjectStub
{
   public legajolicenciasgeneral( )
   {
   }

   public legajolicenciasgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajolicenciasgeneral.class ));
   }

   public legajolicenciasgeneral( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajolicenciasgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajolicenciasgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Legajo Licencias General";
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

