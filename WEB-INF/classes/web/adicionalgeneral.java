package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.adicionalgeneral", "/web.adicionalgeneral"})
public final  class adicionalgeneral extends GXWebObjectStub
{
   public adicionalgeneral( )
   {
   }

   public adicionalgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( adicionalgeneral.class ));
   }

   public adicionalgeneral( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new adicionalgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new adicionalgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Adicional General";
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

