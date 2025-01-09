package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.convenio_adicionalgeneral", "/web.convenio_adicionalgeneral"})
public final  class convenio_adicionalgeneral extends GXWebObjectStub
{
   public convenio_adicionalgeneral( )
   {
   }

   public convenio_adicionalgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( convenio_adicionalgeneral.class ));
   }

   public convenio_adicionalgeneral( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new convenio_adicionalgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new convenio_adicionalgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "convenio_adicional General";
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

