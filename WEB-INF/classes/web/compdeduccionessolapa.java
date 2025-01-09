package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.compdeduccionessolapa", "/web.compdeduccionessolapa"})
public final  class compdeduccionessolapa extends GXWebObjectStub
{
   public compdeduccionessolapa( )
   {
   }

   public compdeduccionessolapa( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( compdeduccionessolapa.class ));
   }

   public compdeduccionessolapa( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new compdeduccionessolapa_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new compdeduccionessolapa_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Comp Deducciones Solapa";
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

