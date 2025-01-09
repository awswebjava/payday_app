package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresareligionesgeneral", "/web.empresareligionesgeneral"})
public final  class empresareligionesgeneral extends GXWebObjectStub
{
   public empresareligionesgeneral( )
   {
   }

   public empresareligionesgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresareligionesgeneral.class ));
   }

   public empresareligionesgeneral( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresareligionesgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresareligionesgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa Religiones General";
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

