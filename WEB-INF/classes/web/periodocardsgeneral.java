package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.periodocardsgeneral", "/web.periodocardsgeneral"})
public final  class periodocardsgeneral extends GXWebObjectStub
{
   public periodocardsgeneral( )
   {
   }

   public periodocardsgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( periodocardsgeneral.class ));
   }

   public periodocardsgeneral( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new periodocardsgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new periodocardsgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Periodo Cards General";
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

