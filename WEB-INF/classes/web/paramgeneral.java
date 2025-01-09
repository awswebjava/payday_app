package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paramgeneral", "/web.paramgeneral"})
public final  class paramgeneral extends GXWebObjectStub
{
   public paramgeneral( )
   {
   }

   public paramgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paramgeneral.class ));
   }

   public paramgeneral( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paramgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paramgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Param General";
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

