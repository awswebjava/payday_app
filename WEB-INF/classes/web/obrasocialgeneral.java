package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.obrasocialgeneral", "/web.obrasocialgeneral"})
public final  class obrasocialgeneral extends GXWebObjectStub
{
   public obrasocialgeneral( )
   {
   }

   public obrasocialgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( obrasocialgeneral.class ));
   }

   public obrasocialgeneral( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new obrasocialgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new obrasocialgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Obra Social General";
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

