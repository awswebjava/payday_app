package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.perfilww", "/web.perfilww"})
public final  class perfilww extends GXWebObjectStub
{
   public perfilww( )
   {
   }

   public perfilww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( perfilww.class ));
   }

   public perfilww( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new perfilww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new perfilww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Perfil";
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

