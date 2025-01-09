package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.banda_salarialgeneral", "/web.banda_salarialgeneral"})
public final  class banda_salarialgeneral extends GXWebObjectStub
{
   public banda_salarialgeneral( )
   {
   }

   public banda_salarialgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( banda_salarialgeneral.class ));
   }

   public banda_salarialgeneral( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new banda_salarialgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new banda_salarialgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "banda_salarial General";
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

