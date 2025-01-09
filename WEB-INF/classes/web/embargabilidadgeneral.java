package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.embargabilidadgeneral", "/web.embargabilidadgeneral"})
public final  class embargabilidadgeneral extends GXWebObjectStub
{
   public embargabilidadgeneral( )
   {
   }

   public embargabilidadgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( embargabilidadgeneral.class ));
   }

   public embargabilidadgeneral( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new embargabilidadgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new embargabilidadgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "embargabilidad General";
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

